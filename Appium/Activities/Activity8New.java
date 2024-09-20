package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity8New {

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
    public void locatorStrategy(){

        // Locate the '5' button by Accessibility ID
        driver.findElement(AppiumBy.accessibilityId("digit_5")).click();

        // Locate the 'equals' button by ID
        driver.findElement(AppiumBy.id("com.android.calculator2:id/eq")).click();

        // Locate the '7' button by name (more commonly by text in Android)
        driver.findElement(AppiumBy.name("7")).click();

        // Locate all buttons by class name
        
        driver.findElements(AppiumBy.className("android.widget.Button")).size();

        // Locate the '2' button by text using UIAutomator
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"2\")")).click();

        // Locate the 'equals' button by resource ID using UIAutomator
        driver.findElement(AppiumBy.androidUIAutomator("new 	UiSelector().resourceId(\"com.android.calculator2:id/eq\")")).click();

        // Locate the '3' button by text using a predicate string (similar to UIAutomator in Android)
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"3\")"));

        // Locate the '4' button using XPath
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='4']")).click();

        // Locate the 'equals' button using XPath
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-	id='com.android.calculator2:id/eq']")).click();


        //assertions
        String result = driver.findElement(AppiumBy.id("com.coloros.calculator:id/result")).getText();
        Assert.assertEquals(result, "5=72=34=");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }



}