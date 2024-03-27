import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty",
                    "json:target/cucumber-reports/cucumber-json-report.json",
                    "html:target/cucumber-reports/cucumber-html-report.html"
                 },
        glue = {"stepDefinitions"},
        features = {"features"},
        monochrome = true
)
public class RunnerTest {

}
