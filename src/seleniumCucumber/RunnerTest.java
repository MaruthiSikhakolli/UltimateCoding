package seleniumCucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "json:target/cucumber-reports/cucumber-json-report.json", "html:target/cucumber-reports/cucumber-html-report.html" },
        glue = {"src/seleniumCucumber/stepDefinition"},
        features = {"src/seleniumCucumber/features"},
        monochrome = true
)

public class RunnerTest {

}
