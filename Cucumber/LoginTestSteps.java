package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps extends BaseClass {
	
	@Given("the user is on the login page")
    public void openPage() throws Throwable {
        // Open the login page
        driver.get("https://training-support.net/webelements/login-form");
        // Assert page title
        Assertions.assertEquals("Selenium: Login Form", driver.getTitle());
    }
 
    @When("the user enters username and password")
    public void enterCredentials() throws Throwable {
        // Find username field and enter username
        driver.findElement(By.id("username")).sendKeys("admin");
        // Find password field and enter password
        driver.findElement(By.id("password")).sendKeys("password");
    }
 
    @When("the user enters {string} and {string}")
    public void enterCredentialsFromInputs(String username, String password) throws Throwable {
        // Find the input fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        // Clear the fields
        usernameField.clear();
        passwordField.clear();
        // Find username field and enter username
        usernameField.sendKeys(username);
        // Find password field and enter password
        passwordField.sendKeys(password);
    }
 
    @And("clicks the submit button")
    public void clickSubmit() throws Throwable {
        // Find the submit button and click it
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
    }
 
    @Then("get the confirmation message and verify it")
    public void confirmMessage() throws Throwable {
        // Find the confirmation message
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"), "Welcome"));
        String message = driver.findElement(By.cssSelector("h2.mt-5")).getText();
        // Assert message
        Assertions.assertEquals("Welcome Back, Admin!", message);
    }
 
    @Then("get the confirmation text and verify message as {string}")
    public void confirmMessageAsInput(String expectedMessage) throws Throwable {
    	// Find the confirmation message
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"), "Welcome"));
        String message = driver.findElement(By.cssSelector("h2.mt-5")).getText();
        // Assert message
        Assertions.assertEquals(expectedMessage, message);
    }
}
