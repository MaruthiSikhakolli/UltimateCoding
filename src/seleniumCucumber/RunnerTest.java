package seleniumCucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                 "json-pretty:target/cucumber-reports/cucumber-json-report.json",
                 "html:target/cucumber-reports/cucumber-html-report.html"
        },
        glue = {"src/seleniumCucumber/stepDefinition"},
        features = {"src/seleniumCucumber/features"},
        monochrome = true
)

public class RunnerTest {
        @BeforeClass
        public static void setup() {
            System.out.println("Before Class");
        }

        @AfterClass
        public static void teardown() {
            System.out.println("After Class");
        }
}
