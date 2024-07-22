package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static activities.ActionBase.doSwipe;

public class Activity5 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);


        driver.get("https://v1.training-support.net/selenium");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")));
        Dimension dims = driver.manage().window().getSize();
        Point start = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.8));
        Point end = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.6));

        doSwipe(driver, start, end, 110);
    }

    @Test(priority = 1)
    public void positiveTest() {
        loginFormWithUsernamePassword("admin", "password");
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Welcome Back, admin\"]")));
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Welcome Back, admin\"]")).isDisplayed());
    }

    @Test(priority = 2)
    public void negativeTest() {
        driver.navigate().back();
        loginFormWithUsernamePassword("user", "password");
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Invalid Credentials\"]")));
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Invalid Credentials\"]")).isDisplayed());
    }

    public void loginFormWithUsernamePassword(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[2]")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[1]")).sendKeys(username);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[2]")).sendKeys(password);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
