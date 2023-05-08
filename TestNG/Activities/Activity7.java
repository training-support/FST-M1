package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(" https://www.training-support.net/selenium/login-form");
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] { { "admin", "password" }};
    }
    @Test(dataProvider = "Authentication")
    public void login(String username, String password) {
        WebElement userName = driver.findElement(By.id("username"));
        WebElement passWord = driver.findElement(By.id("password"));

        userName.sendKeys(username);
        passWord.sendKeys(password);

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String msg = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(msg, "Welcome Back, admin");
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
