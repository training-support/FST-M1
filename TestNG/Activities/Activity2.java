package FSTTestNG.Activities;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Activity2 {
    WebDriver driver;

    @BeforeTest
    public void beforeMethod() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void testCase1() {

        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "Target Practice");
    }

    @Test
    public void testCase2() {

        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "black");
    }

    @Test()
    public void testCase3() {

        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }

    @Test
    public void testCase4() {

        throw new SkipException("Skipping test case");
    }

    @AfterTest
    public void afterMethod() {

        driver.close();
    }

}
