package seleniumCucumber.utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Platform;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class ReportUtils {
    private static final Logger log = Logger.getLogger(ReportUtils.class.getName());
    private static final String projectDir = System.getProperty("user.dir") + File.separator;
    private static final String UtilsDir = projectDir + "src" + File.separator +"framework" + File.separator+"utils" + File.separator;
    private static final String jsonReportDir = projectDir+"target"+File.separator+"json-reports"+File.separator;

    public static void generateReports(String reportDir, boolean localRun) {
        generateCucumberReport(reportDir);
        if(!localRun) {
            createJsonSummary();
            invokePostExecutionUtils();
        }
    }

    public static void generateCucumberReport(String outputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(outputPath), new String[] {"cucumber-json-report.json"}, true);
        final List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));

        Configuration configuration = new Configuration(new File("target"), "Local Automation Run");
        configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
        configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
        configuration.addClassifications("Platform", Platform.getCurrent().name());
        configuration.addClassifications("Browser", ConfigProperties.getBrowser());
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, configuration);
        reportBuilder.generateReports();
    }

    public static void createJsonSummary(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(projectDir+"target" + File.separator + "karate-reports" + File.separator + "karate-summary-json.txt"));
            FileWriter outputFile = new FileWriter(jsonReportDir+"json-summary.json");
            while (bufferedReader.ready())
                outputFile.write(bufferedReader.readLine());
            outputFile.flush();
            outputFile.close();
        } catch(IOException e){
            log.severe("Error writing the summary json file");
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
