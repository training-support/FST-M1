package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 {

    /* 5. Navigate to another page
Goal: Navigate to the “Jobs” page on the site.
a. Open browser with Alchemy Jobs site and navigate to the Jobs page.
b. Search for a particular job and wait for listings to show
c. Click and open any one of the jobs listed.
d. Click the apply button and print the email to the console.
e. Close the browser.
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
    public void JobsMenu() {
        //driver.findElement(By.className("menu-toggle-icon")).click();
        driver.findElement(By.linkText("Jobs")).click();
        String title= driver.getTitle();

        //Assertion
        Assert.assertEquals(title,"Jobs – Alchemy Jobs");

    }

    @Test (dependsOnMethods = "JobsMenu")
    public void SearchJob() {
        driver.findElement(By.xpath("//input[@id='search_keywords']")).
                sendKeys("Banking");
       driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='job_listings']")));
        driver.findElement(By.xpath("//ul[@class='job_listings']/li[1]")).click();
        driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
        //Assertion
       String email= driver.findElement(By.xpath("//a[@class='job_application_email']")).getText();
        System.out.println("Email to apply job is "+email);
    }
    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
