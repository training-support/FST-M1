package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {

    AndroidDriver driver;




    @BeforeClass
    public void setUp() throws MalformedURLException {
        // set the capabilities
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.coloros.calculator")
                .setAppActivity("com.android.calculator2.Calculator")
                .noReset();
        // set the server url
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //initiallize the driver
        driver = new AndroidDriver(serverURL, caps);

    }

    @Test
    public void multiplyTest(){
        //clear the previous calculation
        driver.findElement(AppiumBy.id("com.coloros.calculator:id/img_clr")).click();
        //find the number 7 and tap it
        driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_7")).click();
        //find multiply and tap it
        driver.findElement(AppiumBy.accessibilityId("Multiply")).click();
        //find the number 6 and tap it
        driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_6")).click();
        //find the equal symbol
        driver.findElement(AppiumBy.accessibilityId("Equals")).click();

        //assertions
        String result = driver.findElement(AppiumBy.id("com.coloros.calculator:id/result")).getText();
        Assert.assertEquals(result, "42");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }



}
