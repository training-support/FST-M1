package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {
    // Driver Declaration
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);

        // Open the page in Chrome
        driver.get("https://www.trainig-support.net");
    }

    // Test method
    @Test
    public void chromeTest() {
        // Find heading on the page
        String pageHeading = driver.findElement(AppiumBy.xpath(
                "//android.view.View[@text='Training Support']"
        )).getText();

        // Print to console
        System.out.println("Heading: " + pageHeading);

        // Find and click the About Us link
        driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='about-link']")).click();

        // Find heading of new page and print to console
        String aboutPageHeading = driver.findElement(AppiumBy.xpath(
                "//android.view.View[@text='About Us']"
        )).getText();
        System.out.println(aboutPageHeading);
    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
