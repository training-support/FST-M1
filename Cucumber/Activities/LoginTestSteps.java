package Cucumber_Practise.Features.StepDefinisitons;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTestSteps {
	WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on Login page$")
	public void loginPage() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		driver.get("https://www.training-support.net/selenium/login-form");
		System.out.println("Browser is opened with given URL");

		String title = driver.getTitle();
		System.out.println("Title is:   " + title);
		Assert.assertEquals("Title doesn't match", "Login Form", title);

	}

	@When("^User enters username and password$")
	public void enterCredentials() {

		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("^Read the page title and confirmation message$")
	public void verifyTitleAndValidateMessage() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));

		String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("Message to Validate:" + confirmMessage);
		Assert.assertEquals("Confirmation message doesn't match", "Welcome Back, admin", confirmMessage);
	}

	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_and(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}