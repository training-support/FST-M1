import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = {"stepDefinition"},
        tags = "@SimpleAlert",
        plugin = {"json: test-reports/json-report.json"},
        monochrome = true
)

public class testRunner
{


}
