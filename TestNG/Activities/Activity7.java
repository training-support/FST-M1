package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        //Setup Gecko driver
        WebDriverManager.firefoxdriver().setup();
        //Initialize Firefox
        driver = new FirefoxDriver();
        // Open Browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    @DataProvider(name ="Credentials")
    public static Object[][] creds(){
        return new Object[][] {
                {"admin","password","Welcome Back, Admin"},
        };
    }

    @Test(dataProvider = "Credentials")
    public void loginTest(String username, String password, String message ){
        WebElement usernameField = driver.findElement((By.id("username")));
        WebElement passwordField = driver.findElement((By.id("password")));


        usernameField.clear();
        passwordField.clear();

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String confirmationMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(confirmationMessage, "Welcome Back, admin");
    }

    @AfterClass
    public void tearDown() {
        //close the browser
        driver.quit();
    }
}

