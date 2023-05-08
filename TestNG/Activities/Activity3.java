package activities;

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

public class Activity3 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        //OPen the Page
        driver.get(" https://www.training-support.net/selenium/login-form");
    }

    @Test
    public void login(){
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("admin");
        password.sendKeys("password");

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        WebElement msg= driver.findElement(By.id("action-confirmation"));
        String loginMsg= msg.getText();
        System.out.println(loginMsg);
        Assert.assertEquals(loginMsg,"Welcome Back, admin");

    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
    driver.quit();
    }
}
