package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest extends BaseClass {
    @BeforeAll
    public static void setup() {
        //Set up Browser
        WebDriverManager.firefoxdriver().setup();
        //Initiliaze Firefox driver
        driver = new FirefoxDriver();
    }

    @AfterAll
    public static void teardown() {
        //Close browser
        driver.quit();
    }

    @Given("the user is on the TS Homepage")
    public void openTSHomepage(){

        driver.get("https://v1.training-support.net");
        Assertions.assertEquals("Training Support", driver.getTitle());
    }
    @When("the user clicks on the About Us link")
    public void clickAboutLink(){
        driver.findElement(By.id("about-link")).click();
    }

    @Then("the user is redirected to the About page")
    public void VerifyAboutPage() {
        Assertions.assertEquals("About Training Support", driver.getTitle());
    }


}
