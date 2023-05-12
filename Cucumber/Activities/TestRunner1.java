package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/Features",
        glue = {"stepDefinitions"},
        tags = "@SmokeTest",
        plugin = {"html: reports/HTML_Report.html",
        "junit:reports/Junit_Report.xml",
        "json:reports/JSON_Report.json"},
        publish = true
)

public class TestRunner1 {
    //Empty
}
