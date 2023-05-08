package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity2 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        //OPen the Page
        driver.get(" https://www.training-support.net/selenium/target-practice");
    }
    @Test (priority = 1)
    public void homepageTest(){
        //Verify Page title
        Assert.assertEquals(driver.getTitle(), "Target Practice");
    }

    @Test (priority = 2)
    public void blackButtonTest(){
        WebElement blackButton=driver.findElement(By.className("black"));
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "Black");
    }

    @Test (enabled = false)
    public void SkipTest1(){
        System.out.println("TC is skipped");
    }

    @Test
    public void SkipTest2() {
        throw new SkipException("Skipping test case");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
