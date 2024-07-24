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



public class Activity3
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
    public void calcuations() {
        // Perform the summation
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/clr")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq")).click();
        String sum = driver.findElement(AppiumBy.id("result_final")).getText();

        // Printing and Assertion
        System.out.println("Sum of 5 and 9 is "+ sum);
        Assert.assertEquals(sum, "14");

        //Subtraction
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/clr")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq")).click();
        String balance = driver.findElement(AppiumBy.id("result_final")).getText();

        //Printing and Assertion
        System.out.println("When 5 is deducted from 10, you will get  "+ balance);
        Assert.assertEquals(balance, "5");

        //Multiplication
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/clr")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_mul")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq")).click();
        String product = driver.findElement(AppiumBy.id("result_final")).getText();

        //Printing and Assertion
        System.out.println("Product of 5 and 100  "+ product);
        Assert.assertEquals(product, "500");

        //Division
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/clr")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
        String divResult = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview")).getText();

        //Printing and Assertion
        System.out.println("Result if 50/2 is  "+ divResult);
        Assert.assertEquals(divResult, "25");

    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
