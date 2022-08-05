package StepDefinitions;

import io.cucumber.java.en.And;

public class CloseBrowser extends BaseClass{

    @And("^Close the browser$")

    public void CloseBrowser(){
        driver.quit();
    }
}
