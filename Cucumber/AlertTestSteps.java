package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertTestSteps extends BaseClass {
	Alert alert;

	@Given("User is on the page")
	public void openPage() {
		// Open browser
		driver.get("https://training-support.net/webelements/alerts");
	}

	@When("User clicks the Simple Alert button")
	public void openSimpleAlert() {
		driver.findElement(By.id("simple")).click();
	}

	@When("User clicks the Confirmation Alert button")
	public void openConfirmAlert() {
		driver.findElement(By.id("confirmation")).click();
	}

	@When("User clicks the Prompt Alert button")
	public void openPromptAlert() {
		driver.findElement(By.id("prompt")).click();
	}

	@Then("Alert opens")
	public void switchFocus() {
		alert = driver.switchTo().alert();
	}

	@And("Read the text from it and print it")
	public void readAlert() {
		System.out.println("Alert says: " + alert.getText());
	}

	@And("Write a custom message in it")
	public void writeToPrompt() {
		alert.sendKeys("Custom Message");
	}

	@And("Close the alert")
	public void closeAlert() {
		alert.accept();
	}

	@And("Close the alert with Cancel")
	public void closeAlertWithCAncel() {
		alert.dismiss();
	}

	@And("Read the result text")
	public void readResultText() {
		String message = driver.findElement(By.id("result")).getText();
		System.out.println("Action performed: " + message);
	}

}