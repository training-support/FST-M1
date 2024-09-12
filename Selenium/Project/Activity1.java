package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity1 {

    /*1. Verify the website title
    Goal: Read the title of the website and verify the text
    a. Open a browser.
    b. Navigate to ‘https://alchemy.hguy.co/jobs’.
    c. Get the title of the website.
    d. Make sure it matches “Alchemy Jobs – Job Board Application” exactly.
    e. If it matches, close the browser.*/

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
    public void testTitle() {
        String title = driver.getTitle();

        //Assertion
        Assert.assertEquals(title, "Alchemy Jobs – Job Board Application");
    }
    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
