package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Activity6 {
    AndroidDriver driver;
    WebDriverWait wait;
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
        driver.get("https://v1.training-support.net/selenium/lazy-loading");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @Test
    public void browserTest(){
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Image")));
        List<WebElement> imageElements = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("Before scroll: " + imageElements.size());

        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"helen\")"));

        imageElements = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("After scroll: " + imageElements.size());
        assertEquals(imageElements.size(), 5);
    }
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}