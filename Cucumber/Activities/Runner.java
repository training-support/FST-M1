package Cucumber_Practise.Features.StepDefinisitons;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Cucumber_Practise/Features/Activity1.feature",
    glue = {"stepDefinitions"},
    plugin = { "pretty" ,"html:target/Reports/index.html", "json:target/Reports/cucumber.json" },
    tags = "@activity1",
    monochrome = true
)
 
public class Runner {
    //empty
}
