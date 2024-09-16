package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinition"},
        tags = "@SmokeTest",
        plugin = {"pretty","html:test-reports/index.html","json: test-reports/json-report.json"},
        monochrome = true
)
public class Activity6jsonrunner {
}
