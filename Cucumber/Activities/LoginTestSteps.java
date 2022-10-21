package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginTestSteps {
	WebDriver driver;
    WebDriverWait wait;
    
    @Given("^User is on Login page$")
    public void userIsOnLoginPage() throws Throwable {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 15);
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    
    @When("^User enters username and password$")
    public void userEnterData() throws Throwable {
    	driver.findElement(By.id("username")).sendKeys("admin");
    	driver.findElement(By.id("password")).sendKeys("password");
    	driver.findElement(By.xpath("//button[@class='ui button']")).click();
    }
    
    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void user_enters_and(String username, String password) throws Throwable {
       
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
 
    @Then("^Read the page title and confirmation message$")
    public void readPageTitle() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        System.out.println("Page Title " + driver.getTitle());
        String confirmationMsg = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login confirmation msg is : " + confirmationMsg);
        
        if(confirmationMsg.contains("admin")) {
            Assert.assertEquals(confirmationMsg, "Welcome Back, admin");
        } else {
            Assert.assertEquals(confirmationMsg, "Invalid Credentials");
        }
    }
 
    @And("^Close the browser$")
    public void closeTheBrowser() throws Throwable {
        driver.close();
    }

}
