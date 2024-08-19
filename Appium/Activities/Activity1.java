package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException{
        //Set the desired capabilities
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UIAutomator2")
                .setAppPackage("com.android.calculator2")
                .setAppActivity(".Calculator")
                .noReset();

        //Set the appium severURL
        URL serverUrl= new URL("http://localhost:4723/wd/hub");

        //Initialize the android driver
        driver = new AndroidDriver(serverUrl, caps);
    }

    @Test
    public void multiplyTest(){
        //Find number9 and tap it
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
        // Find multiply and tap it
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_mul")).click();
        //Find the number 6 and tap it
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_6")).click();
        //Find the symbol = and tap it
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();
        String result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
        Assert.assertEquals(result,"54");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
