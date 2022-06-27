package ActivityRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features",
	    glue = {"stepDefinitions"},
	    tags = "@SimpleAlert",
	    plugin = {"html:target/test-reports/json-report.json"},
	    monochrome = true
	    
	//For Activity6.feature
	//tags = "@SimpleAlert",
	//plugin = {"pretty"},
	//monochrome = true
	    
	//tags = "@SimpleAlert",
	//plugin = {"html:target/test-reports/html-report"},
	//monochrome = true
	    
	//tags = "@SimpleAlert",
	//plugin = {"json:target/test-reports/json-report.json"},
	//monochrome = true
	    
    //For Activity3.feature
    //tags = "@activity3"
    //tags= "@SimpleAlert or @ConfirmAlert"
    //tags= "PromptAlert"
    //tags= "SmokeTest"
    
    //tags= "@activity5" 
    
    //features = "Features/Activity2.feature",
    //glue = {"StepDefinitions"}
)

public class Runner {
    
}
