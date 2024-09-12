package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity2 {

    /*1. Verify the website title
    Goal: Read the title of the website and verify the text
    a. Open a browser.
    b. Navigate to ‘https://alchemy.hguy.co/jobs’.
    c. Get the heading of the page.
    d. Make sure it matches “Welcome to Alchemy Jobs” exactly.
    e. If it matches, close the browser..*/

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Initialize Firefox driver object
        driver = new FirefoxDriver();
        // Initialize wait object
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open browser
        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test
    public void testHeading() {
        String heading = driver.findElement(By.cssSelector("h1.entry-title")).getText();

        //Assertion
        Assert.assertEquals(heading, "Welcome to Alchemy Jobs");
    }
    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
