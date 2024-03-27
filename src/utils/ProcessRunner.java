package utils;

import org.apache.commons.lang3.StringUtils;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

public class ProcessRunner {
    private List<String> commands;
    private String strCurrentWorkingDir;
    private volatile Process currentProcess;
    private final List<Thread> outputErrorThreads = new ArrayList<>();
    private final List<String> outputContent = new CopyOnWriteArrayList<>();
    private final List<String> errorContent = new CopyOnWriteArrayList<>();
    private final List<ProcessOutputListener> processListeners = new CopyOnWriteArrayList<>();
    private final Logger log = Logger.getLogger(this.getClass().getName());
    private boolean dontLog;

    public ProcessRunner(List<String> commands) {
        this.commands = commands;
    }

    public boolean execute(String successMessage, String failureMessage) {
        boolean status = false;
        int exitCode = runProcessAndWaitToComplete();
        if (exitCode == 0) {
            log.info(StringUtils.join(getOutput().toArray()));
            log.info(successMessage);
            status = true;
        } else {
            log.severe(failureMessage);
            String strErrorInfo = StringUtils.join(getError().toArray());
            log.severe(strErrorInfo);
        }
        return status;
    }

    public boolean execute(List<String> commands,String successMessage , String failureMessage) {
        return execute(commands,successMessage,failureMessage,false);
    }

    /**
     * execute - Function to trigger the Process Runner
     * @param commands
     * @param successMessage
     * @param failureMessage
     * @param noLog - When set to True will not print Logs
     * @return
     */
    public boolean execute(List<String> commands,String successMessage , String failureMessage , boolean noLog) {
        boolean status;
        ProcessRunner runner = new ProcessRunner(commands);
        int exitCode = runner.runProcessAndWaitToComplete();

        if (exitCode == 0) { // Success in appleconnect LogOut
            if(noLog) {
                StringUtils.join(runner.getOutput().toArray());
            }else {
                log.info(StringUtils.join(runner.getOutput().toArray()));
            }
            log.info(successMessage );
            status = true;
        } else {
            log.severe(failureMessage);
            String strErrorInfo = StringUtils.join(runner.getError().toArray());
            log.severe(strErrorInfo);
            status = false;
        }
        return status;
    }

    public int runProcessAndWaitToComplete() {
        this.run();
        return this.waitForProcessToComplete();
    }

    private void run() {
        try {
            ProcessBuilder pBuilder = new ProcessBuilder(this.commands);
            if (StringUtils.isNotBlank(this.strCurrentWorkingDir)) {
                pBuilder.directory(new File(this.strCurrentWorkingDir));
            }

            this.currentProcess = pBuilder.start();
            InputStream output = this.currentProcess.getInputStream();
            InputStream error = this.currentProcess.getErrorStream();
            this.outputErrorThreads.add(this.getDataMonitorInThread(output, true));
            this.outputErrorThreads.add(this.getDataMonitorInThread(error, false));
        } catch (Exception var4) {
            log.severe("Exception occurred while launching the process:::" +var4.getMessage());
        }
    }

    private Thread getDataMonitorInThread(final InputStream in, final boolean outputErrorFlag) {
        Thread currentThread = new Thread(() -> {
            BufferedReader reader;
            reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    appendDataToStore(line, outputErrorFlag);
                }
            } catch (IOException var5) {
                var5.printStackTrace();
            }

        });
        currentThread.start();
        return currentThread;
    }

    private void appendDataToStore(String line, boolean outputErrorFlag) {
        if (outputErrorFlag) {
            this.outputContent.add(line);
        } else {
            this.errorContent.add(line);
        }

        for (ProcessOutputListener l : this.processListeners) {
            if (outputErrorFlag) {
                l.outStream(line);
            } else {
                l.errorStream(line);
            }
        }
    }

    public int waitForProcessToComplete() {
        int exitCode = -1;
        if (this.currentProcess == null) {
            return exitCode;
        } else {
            try {
                exitCode = this.currentProcess.waitFor();
            } catch (Exception var6) {
                log.severe("Exception occurred while waiting for the process to complete.:::" +var6.getMessage());
                return exitCode;
            }

            for (Thread t : this.outputErrorThreads) {
                try {
                    t.join();
                } catch (Exception ignored) {
                }
            }
            return exitCode;
        }
    }

    public List<String> getOutput() {
        return this.outputContent;
    }

    public List<String> getError() {
        return this.errorContent;
    }



}
