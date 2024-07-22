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

public class FirstExample {
    WebDriverWait wait;
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

        // Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page in browser
        driver.get("https://training-support.net/selenium/TargetPractice");
    }

    @Test
    public void listElements() {
        // Wait for elements to load
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.className("android.webkit.WebView")));

        // Find all text elements on the page
        List<WebElement> textItems = driver.findElements(
                AppiumBy.xpath("//android.view.View/android.widget.Button")
        );
        System.out.println(textItems.size());
        for (WebElement textItem : textItems) {
            System.out.println(textItem.getText());
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}