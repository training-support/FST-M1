package CucumberPgms;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefinitions"},
	    tags = "@SimpleAlert",
	    plugin = {"pretty"},
	    monochrome = true
	)
 
public class Activity6_Usingpretty {
    //empty
}
