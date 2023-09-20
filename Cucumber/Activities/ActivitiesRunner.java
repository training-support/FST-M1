package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinitions"},
        tags = "@activity5",
        plugin = {"html:test-reports/HTML_Report.html" ,
                "json:test-reports/json-report.json"},
        monochrome = true
)

public class ActivitiesRunner {
    //empty
}
