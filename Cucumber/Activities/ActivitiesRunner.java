package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Activity1",
        glue = {"StepDefinitions"},
        tags = "@Activity1"
)

public class ActivitiesRunner {
    //empty
}