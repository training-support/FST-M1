package TeststepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps {
	WebDriver driver;
    WebDriverWait wait;
    
    @Given("^User is on Google Home Page$")
    public void userIsOnGooglePage() throws Throwable {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
                
        
        driver.get("https://www.google.com");
    }
    
    @When("^User types in Cheese and hits ENTER$")
    public void userTypesInCheeseAndHitsENTER() throws Throwable {
        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
    }
 
    @Then("^Show how many search results were shown$")
    public void showHowManySearchResultsWereShown() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
        String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of results found: " + resultStats);
    }
 
    @And("^Close the browser$")
    public void closeTheBrowser() throws Throwable {
        driver.close();
    }

}
