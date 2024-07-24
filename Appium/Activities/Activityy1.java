package Examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity1
{
    // Driver Declaration
    AndroidDriver driver;

    // Setting up
    @BeforeClass
    public void setUp() throws MalformedURLException {


        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    // Test method
    @Test
    public void multiplyTest() {
        // Perform the calculation
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_mul")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_4")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq")).click();


        String product = driver.findElement(AppiumBy.id("result_final")).getText();

        // Assertion
        Assert.assertEquals(product, "20");
    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
