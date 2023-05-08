package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass(alwaysRun = true)
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        Reporter.log("Opened Browser |");
    }
    @BeforeMethod
    public void beforeMethod() {
        Reporter.log("Test Case Setup started |");
        driver.switchTo().defaultContent();
    }
    @Test
    public void simpleAlertTestCase(){
        driver.findElement(By.id("simple")).click();
        Reporter.log("Simple Alert opened |");
        Alert simpleAlert = driver.switchTo().alert();
        String alertText = simpleAlert.getText();
        System.out.println("Alert text is: " + alertText);
        Assert.assertEquals("This is a JavaScript Alert!", alertText);
        simpleAlert.accept();
        Reporter.log("Alert closed");
    }
    @Test
    public void confirmAlertTestCase(){
        driver.findElement(By.id("confirm")).click();
        Reporter.log("Confirm Alert opened |");
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text is: " + alertText);
        Assert.assertEquals("This is a JavaScript Confirmation!", alertText);
        //alert.accept();
        alert.dismiss();
        Reporter.log("Alert closed |");
    }
    @Test
    public void promptAlertTestCase(){
        driver.findElement(By.id("prompt")).click();
        Reporter.log("Prompt Alert opened |");
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text is: " + alertText);
        Assert.assertEquals("This is a JavaScript Prompt!", alertText);
        alert.sendKeys("Hello");
        alert.accept();
        Reporter.log("Alert closed |");
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
