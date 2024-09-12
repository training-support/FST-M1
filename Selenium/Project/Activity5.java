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

public class Activity5 {

    /* 5. Navigate to another page
Goal: Navigate to the “Jobs” page on the site.
a. Open a browser.
b. Navigate to ‘https://alchemy.hguy.co/jobs’.
c. Find the navigation bar.
d. Select the menu item that says “Jobs” and click it.
e. Read the page title and verify that you are on the correct page.
f. Close the browser.
.*/

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
    public void MainMenu() {
        //driver.findElement(By.className("menu-toggle-icon")).click();
        driver.findElement(By.linkText("Jobs")).click();
        String title= driver.getTitle();

        //Assertion
        Assert.assertEquals(title,"Jobs – Alchemy Jobs");

    }
    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
