package stepDefination;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Activity1Test {

    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on the google homepage$")
    public void GoogleHomePage() throws Throwable{
     driver = new FirefoxDriver();
     wait = new WebDriverWait(driver,10);
     driver.get("https://www.google.com");

   }
    @When("^user types in cheese and hit enter$")
    public void GoogleSearch() throws Throwable{

        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);

    }

    @Then("^show how many search results were generated$")
    public void SearchResults() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
        String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of results found: " + resultStats);
    }

    @And("^Close the Browser$")
    public void closeTheBrowser() throws Throwable {
        driver.close();
    }


}
