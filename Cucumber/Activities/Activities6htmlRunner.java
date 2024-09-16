package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinition"},
        tags = "@SmokeTest",
        plugin = {"html:index.html"},
        monochrome = true
)

public class Activities6htmlRunner {

}