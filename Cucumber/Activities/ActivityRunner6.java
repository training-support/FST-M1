package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinitions"},
        tags = "@activity5",
        plugin = {"html: test-reports"},
        monochrome = true
)
public class ActivityRunner6 {
    //empty
}