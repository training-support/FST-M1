package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        driver.get("https://www.training-support.net/");
    }
    @Test
    public void browserTest() throws InterruptedException {


        String pageTitle=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")).getText();
        System.out.println(pageTitle);
        driver.findElement(AppiumBy.accessibilityId("About Us")).click();
        String aboutUsPageTitle=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).getText();
        System.out.println(aboutUsPageTitle);

    }


    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
