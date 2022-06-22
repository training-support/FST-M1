package Cucumber_Practise.Features.StepDefinisitons;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FirstTest extends BaseClass{

    @Given("^User is on the Login page$")
    public void openBrowser(){
        driver.get("https://www.training-support.net");

        String title = driver.getTitle();
        Assert.assertEquals("Title doesn't match","Training Support",title);
    }

    @When("^User enters the username and password$")
    public void enterCredential(){

        driver.findElement(By.linkText("About Us")).click();

    }


}