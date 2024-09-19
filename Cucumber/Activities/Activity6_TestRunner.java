package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions"},
        tags = "@SimpleAlert",
        plugin = {"pretty",
                "html: test-reports",
                "json: test-reports/json-report.json"
        },
        monochrome = true
)

public class TestRunner6 {

}