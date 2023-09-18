package Activities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class Activity3 {
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.coloros.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }
    @Test
    public void additionTest(){
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("Add")).click();
        driver.findElement(AppiumBy.id("digit_9")).click();
        driver.findElement(AppiumBy.id("eq")).click();
        String result=driver.findElement(AppiumBy.id("result")).getText();
        assertEquals(result,"14","Expected output not generated.");
        System.out.println("Sum of 5 and 9="+result);
    }

    @Test
    public void subtractionTest(){
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("Subtract")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("eq")).click();
        String result=driver.findElement(AppiumBy.id("result")).getText();
        assertEquals(result,"5","Expected output not generated.");
        System.out.println("Subtracting 5 from 10="+result);
    }

    @Test
    public void multiplicationTest(){
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("Multiply")).click();
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("eq")).click();
        String result=driver.findElement(AppiumBy.id("result")).getText();
        assertEquals(result,"500","Expected output not generated.");
        System.out.println("Multiplying 5 with 100="+result);
    }

    @Test
    public void divisionTest(){
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("Divide")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.id("eq")).click();
        String result=driver.findElement(AppiumBy.id("result")).getText();
        assertEquals(result,"25","Expected output not generated.");
        System.out.println("Diving 50 by 2="+result);
    }

    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
