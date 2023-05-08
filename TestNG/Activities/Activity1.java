package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity1 {
    //Driver declaration
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));

        //OPen the Page
        driver.get("https://www.training-support.net");
    }

    @Test (priority = 1)
    public void homepageTest(){
        //Verify Page title
        Assert.assertEquals(driver.getTitle(), "Training Support");

        //Find and click About us
        driver.findElement(By.id("about-link")).click();
    }
    @Test(priority = 2)
    public void aboutPageTest(){
        //wait for the page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        System.out.println(driver.getTitle());
        //Verify Page title
        Assert.assertEquals(driver.getTitle(), "About Training Support");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
