package testRunner;

public class ActivityRunner5 {
    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "Features",
            glue = {"stepDefinitions"},
            tags = "@activity5"
    )

    public class ActivityRunner5 {}
}
