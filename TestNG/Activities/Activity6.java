package activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        // Initialize the Chrome driver
        driver = new ChromeDriver();
        // Initialize the wait object
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open browser
        driver.get("https://training-support.net/webelements/login-form");
    }

    @Test
    @Parameters({ "username", "password", "message" })
    public void loginTestCase(String username, String password, @Optional("Login Success!") String message) {
        // Find username and password fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        // Enter credentials
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        // Click the submit button
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        // Wait for the success page to load
        wait.until(ExpectedConditions.titleContains("Success"));

        // Assert login message
        String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
        Assert.assertEquals("Welcome Back, Admin!", loginMessage);
    }

    @AfterClass
    public void afterClass() {
        // Close browser
        driver.close();
    }
}
