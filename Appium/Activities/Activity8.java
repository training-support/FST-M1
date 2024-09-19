package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity8 {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set Capabilities
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.vivo.calculator")
                .setAppActivity(".Calculator")
                .noReset();

        //Set serverUrl
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Initialize driver
        driver = new AndroidDriver(serverURL, caps);
    }

    @Test
    public void multiplyTest() {
        //Find number 7 and tap it
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@resource-id=\"com.vivo.calculator:id/digit_7\"]")).click();
        //Find  "*" and tap it
        driver.findElement(AppiumBy.accessibilityId("Multiply")).click();
        //Find number 5 and tap it
        driver.findElement(AppiumBy.id("com.vivo.calculator:id/digit_5")).click();
        //Find "=" and tap it
        driver.findElement(AppiumBy.id("com.vivo.calculator:id/eq")).click();
        String calculatedValue = driver.findElement(AppiumBy.id("com.vivo.calculator:id/formula")).getText();
        //Assertion
        Assert.assertEquals("35", calculatedValue);
    }
}