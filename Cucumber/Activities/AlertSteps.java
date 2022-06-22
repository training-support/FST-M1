package Cucumber_Practise.Features.StepDefinisitons;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertSteps {

	WebDriver driver;
	WebDriverWait wait;
	Alert alert;

	@Given("^User is on the page$")
	public void user_is_on_the_page() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		System.out.println("Browser is opened with given URL");

		String title = driver.getTitle();
		System.out.println("Title is:   " + title);
	}

	@When("^User clicks the Simple Alert button$")
	public void user_clicks_the_simple_alert_button() {
		driver.findElement(By.id("simple")).click();
		System.out.println("Simple alert button is clicked");
	}

	@When("^User clicks the Confirm Alert button$")
	public void user_clicks_the_confirm_alert_button() {
		driver.findElement(By.cssSelector("#confirm")).click();
		System.out.println("Confirm alert button is clicked");
	}

	@When("^User clicks the Prompt Alert button$")
	public void user_clicks_the_prompt_alert_button() {
		driver.findElement(By.xpath("//button[text()='Prompt']")).click();
		System.out.println("Prompt alert button is clicked");
	}

	@Then("^Alert opens$")
	public void alert_opens() {
		alert = driver.switchTo().alert();
		System.out.println("Focus is moved to alert");
	}

	@Then("^Read the text from it and print it$")
	public void read_the_text_from_it_and_print_it() {
		String alertTxt = driver.switchTo().alert().getText();
		System.out.println("Alert Text:  " + alertTxt);
	}

	@And("^Write a custom message in it$")
	public void write_a_custom_message_in_it() {
		alert.sendKeys("This is prompt alert");
		System.out.println("Text is entered in Prompt alert");
	}

	@And("^Close the alert$")
	public void close_the_alert() {

		alert.accept();
		System.out.println("Alert is accepted and closed");
	}

	@Then("^Close the alert with Cancel$")
	public void close_the_alert_with_cancel() {
		alert.dismiss();
		System.out.println("Alert is cancelled and closed");
	}

	@Then("^Read the result text$")
	public void read_the_result_text() {

	}

	@Then("^Close Browser$")
	public void close_browser() {
		System.out.println("Closing all the browsers opened by automation");
		driver.quit();
	}

}