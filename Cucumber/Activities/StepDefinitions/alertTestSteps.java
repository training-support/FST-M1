package StepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class alertTestSteps {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @Given("^User is on the page$")
    public void openPage() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }

    @When("^User clicks the Simple Alert button$")
    public void openSimpleAlert() {
        driver.findElement(By.cssSelector("#simple")).click();
    }

    @When("^User clicks the Confirm Alert button$")
    public void openConfirmAlert() {
        driver.findElement(By.cssSelector("#confirm")).click();
    }

    @When("^User clicks the Prompt Alert button$")
    public void openPromptAlert() {
        driver.findElement(By.cssSelector("#prompt")).click();
    }

    @Then("^Alert opens$")
    public void alertOpens() {
        alert = driver.switchTo().alert();
    }

    @And("^Read the text from it and print it$")
    public void readText() {
        System.out.println("Alert says :"+alert.getText());
    }

    @And("^Write a custom message in it$")
    public void writeMessage() {
        alert.sendKeys("Hi! How are you ?");
    }

    @And("^Close the alert$")
    public void closeAlert() {
        alert.accept();
    }

    @And("^Close the alert with Cancel$")
    public void closeAlertCancel() {
        alert.dismiss();
    }

    @And("^Read the result text$")
    public void resultText() {

    }

    @And("^Close Browser$")
    public void closeBrowser() {
        driver.close();
    }

}
