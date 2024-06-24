package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstExample extends BaseClass {
    @BeforeAll
    public static void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://v1.training-support.net/");
    }
    @AfterAll
    public static void closebrowser(){
        driver.close();
    }
    @Given("the user is on the TS homepage")
    public void openTSpage(){
        driver.get("http://v1.training-support.net/");
        Assertions.assertEquals("Training Support",driver.getTitle());
    }
    @When("the user clicks on the About Us Link")
    public void clickLink(){
        WebElement web1=driver.findElement(By.id("about-link"));
        web1.click();
        //Assertions.assertEquals("True",web1.isEnabled());
    }
    @Then("the user is redirected to About page")
    public void redirectpage(){
        Assertions.assertEquals("About Training Support",driver.getTitle());
    }

}
