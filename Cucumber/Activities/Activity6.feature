@RunWith(Cucumber.class)
@CucumberOptions(
features = "Features",
glue = {"stepDefinitions"},
tags = "@SimpleAlert",
plugin = {"json: test-reports/json-report.json"},
monochrome = true
)

public class ActivitiesRunner {}