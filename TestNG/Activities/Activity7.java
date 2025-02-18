package activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Initialize driver
        driver = new ChromeDriver();
        // Initialize wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Open the page
        driver.get("https://training-support.net/webelements/login-form");
    }

    @DataProvider(name = "Credentials")
    public static Object[][] creds() {
        return new Object[][] { 
            { "admin", "password", "Welcome Back, Admin!" },
            { "wrongAdmin", "wrongPassword", "Invalid Credentials" }
        };
    }

	
	
    @Test(dataProvider = "Credentials")
    public void loginTest(String username, String password, String expectedMessage) {
        // Find the input fields and the login button
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Submit']"));

        // Clear the input fields
        usernameField.clear();
        passwordField.clear();
        
        // Enter the credentials and click Log in
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        // Assert login message
        String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
        Assert.assertEquals(loginMessage, expectedMessage);
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}