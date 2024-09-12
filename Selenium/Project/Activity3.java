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

import java.sql.SQLOutput;
import java.time.Duration;

public class Activity3 {

    /*1. Verify the website title
    Goal: Read the title of the website and verify the text
    a. Open a browser.
    b. Navigate to ‘https://alchemy.hguy.co/jobs’.
    c. Get the url of the header image.
    d. Print the url to the console.
    e. Close the browser..*/

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
    public void testHeaderImage() {
        WebElement headerImage= driver.findElement(By.xpath
                ("//article[@id='post-16']/header/div/img"));
        String url = headerImage.getAttribute("src");
        //print url
        System.out.println("Header Image URL is "+ url);
    }
    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
