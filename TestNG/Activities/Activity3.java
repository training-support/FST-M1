package TestNGActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @Test
    public void loginTest() throws InterruptedException {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys("admin");
        password.sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(2000);
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("login message: "+loginMessage);
        Assert.assertEquals("Welcome Back, admin", loginMessage);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
