package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Activity1 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        //Desired Capabilities
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();

        //Appium Server URL
        URL serverURL= new URL ("http://localhost:4723/wd/hub");

        //Driver Initialization
        driver=new AndroidDriver(serverURL,options);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void multiplicationTest(){
        //Find and Tap 5 digit
        WebElement digit5=driver.findElement(AppiumBy.id("digit_5"));
        digit5.click();
        //Find and Tab the multiply operator
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        //Find and Tap 5 digit
        digit5.click();
        //Find and Tab the equals operator
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        //Assertions
        String resultText=driver.findElement(AppiumBy.id("result")).getText();
        assertEquals(resultText,"25");
    }

    @AfterClass
    public void teardown(){
        //Close the APP
        driver.quit();
    }

}
