package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SecondExample {
    WebDriverWait wait;
    AndroidDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
       // options.setAppPackage("com.android.chrome");
        //options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page in browser
        //driver.get("https://www.training-support.net/selenium/target-practice");
    }
    @Test(priority = 1)
    public void phoneclick(){
        WebElement mobile1=driver.findElement(AppiumBy.accessibilityId("Phone"));
        mobile1.click();
    }
    @AfterClass
    public void close(){
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));

    }
}
