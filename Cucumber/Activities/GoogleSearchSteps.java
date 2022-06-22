package Cucumber_Practise.Features.StepDefinisitons;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchSteps {
    WebDriver driver;
    WebDriverWait wait;
    @Given("^User is on Google Home Page$")
    public void openGoogle() {

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("https://www.google.co.in/");
        System.out.println("Browser is opened with given URL");

        String title = driver.getTitle();
        System.out.println("Title is:   "+title);
    }

    @When("^User types in Cheese and hits ENTER$")
    public void enterCheese() {
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Cheese");
        System.out.println("Cheese is entered in Search bar");
    }

    @Then("^Show how many search results were shown$")
    public void searchResult() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']/li")));
        int resultCounts = driver.findElements(By.xpath("//ul[@role='listbox']/li")).size();

        System.out.println("Number of results found: " + resultCounts);
    }
    @And("^Close the browser$")
    public void closeBrowser(){
        driver.quit();
    }
}