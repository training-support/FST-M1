package project;

import activities.ActionsBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity6 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void SetUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://v1.training-support.net/selenium");
    }

    @Test
    public void loginTestInvalid() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]"))).click();

        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"Login Form\")"));

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]"))).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Login Form\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")).sendKeys("admin1");
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Login Form\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")).sendKeys("password1");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Invalid Credentials\"]")).isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
