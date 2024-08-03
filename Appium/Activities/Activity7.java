package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity7 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void SetUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);

        driver.get("https://v1.training-support.net/selenium/lazy-loading");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void webAppTest() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Lazy Loading\"]")));

        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward().getChildByText(className(\"android.widget.Image\"), \"helen\")"));
        List<WebElement> imagesAfterScroll = driver.findElements(AppiumBy.xpath("//android.widget.Image"));

        Assert.assertEquals(imagesAfterScroll.size(), 2);
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
