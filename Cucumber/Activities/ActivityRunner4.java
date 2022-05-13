package testRunner;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions"},
        tags = "@activity4"
)

public class ActivityRunner4 {}{
        }
