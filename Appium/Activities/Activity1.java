package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    // Driver Declaration
    AndroidDriver driver;

    //set up method
    @BeforeClass
    public void setup() throws MalformedURLException{
        //set the desired capabilities for Android
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.android.calculator2")
                .setAppActivity(".Calculator")
                .noReset();

        /*
        //set the desired capabilities for IOS
        XCUITestOptions caps2 = new XCUITestOptions()
                .setPlatformName("ios")
                .setAutomationName("XCUITest")
                .setApp("path/to/.ipaFile")
                .noReset();
        */


        //Set the Appium server
        URL serverurl = new URL("http://localhost:4723/wd/hub");

        //Initiate the Android Driver
        driver = new AndroidDriver(serverurl, caps);
    }
    @Test
    public void multiplyTest() {
        //Find number 9 and Tap it
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
        // Find the multiply and tap it
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_mul")).click();
        //Find the number 6 and Tap it
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_6")).click();
        //Find equal symbol and tap it
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();
        //Get the result and assert
        String result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
        Assert.assertEquals(result, "54");
    }

    @Test
    public void addTest() {
        //Find number 9 and Tap it
        driver.findElement(AppiumBy.id("digit_9")).click();
        // Find the multiply and tap it
        driver.findElement(AppiumBy.id("op_add")).click();
        //Find the number 6 and Tap it
        driver.findElement(AppiumBy.id("digit_6")).click();
        //Find equal symbol and tap it
        driver.findElement(AppiumBy.id("eq")).click();
        //Get the result and assert
        String result = driver.findElement(AppiumBy.id("result")).getText();
        Assert.assertEquals(result, "15");
    }

    @AfterClass
    public void teardown() {
        //close the App
        driver.quit();
    }
}
