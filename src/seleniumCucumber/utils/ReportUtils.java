package seleniumCucumber.utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public class ReportUtils {
    private static final Logger log = Logger.getLogger(ReportUtils.class.getName());
    private static final String projectDir = System.getProperty("user.dir") + File.separator;
    private static final String UtilsDir = projectDir + "src" + File.separator +"framework" + File.separator+"utils" + File.separator;
    private static final String reportUtilsDir = UtilsDir+File.separator+"reports"+File.separator;
    private static final String jsonReportDir = projectDir+"target"+File.separator+"json-reports"+File.separator;

    public static void generateReports(String reportDir, boolean localRun) {
        generateCucumberReport(reportDir);
        if(!localRun) {
            createJsonSummary();
            invokePostExecutionUtils();
        }
    }

    public static void generateCucumberReport(String outputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(outputPath), new String[] {"json"}, true);
        final List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "Demo");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }

    public static void createJsonSummary(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(projectDir+"target" + File.separator + "karate-reports" + File.separator + "karate-summary-json.txt"));
            FileWriter outputFile = new FileWriter(jsonReportDir+"karate-summary.json");
            while (bufferedReader.ready())
                outputFile.write(bufferedReader.readLine());
            outputFile.flush();
            outputFile.close();
        } catch(IOException e){
            log.severe("Error writing the karate summary json file");
        }
    }

    public static void invokePostExecutionUtils() {
        List<String> cmds = new ArrayList<>();
        cmds.add("python3");
        cmds.add(UtilsDir+File.separator+"python_utils/postExecutionUtilities/"+"postExecutionUtility.py");
        cmds.add(jsonReportDir+"postExecutionConfig.json");
        ProcessRunner runner = new ProcessRunner(cmds);
        runner.execute("Successfully Triggered Post Execution Utility", "Failed to trigger the Post Execution Utility");
    }
}
