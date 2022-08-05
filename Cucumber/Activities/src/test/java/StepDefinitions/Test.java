package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Test extends BaseClass {
    @Given("^User opens Training Support Site$")
    public void OpenBrowser() {

        setup();
        driver.get("https://training-support.net");

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Training Support");
    }

    @When("^the user clicks About Us button$")
    public void ClickAboutUs() {
        driver.findElement(By.id("about-link")).click();
    }

    @Then("^the About Us page opens$")
    public void VerifyPage() {
        String VerifyTitle = driver.getTitle();
        Assert.assertEquals(VerifyTitle, "About Training Support");
    }


}
