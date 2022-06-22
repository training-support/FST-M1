package Cucumber_Practise.Features.StepDefinisitons;

import io.cucumber.java.en.And;

public class CloseBrowser extends BaseClass {

	
	@And("^Close the browser$")
	public void closeTheBrowser() {
		driver.close();
	}
}
