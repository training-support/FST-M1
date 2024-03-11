package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@cucumber.api.CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@activity1_1"
)

public class ActivitiesRunner {
	
	

}
