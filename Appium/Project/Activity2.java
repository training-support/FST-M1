package Project;

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

public class Activity2 {
    WebDriverWait wait;
    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test(priority = 1)
    public void addnote() {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/new_note_button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/editable_title"))).sendKeys("Break Time");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/edit_note_text"))).sendKeys("its break time now");
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        boolean b = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/index_note_title"))).isDisplayed();
        System.out.println(b);
        if (b == true) {
            List<WebElement> titles = driver.findElements(AppiumBy.id("com.google.android.keep:id/index_note_title"));
            for (WebElement title : titles) {
                String title_value = title.getText();
                System.out.println(title_value);
                if (title_value.equalsIgnoreCase("Break Time")) {
                    Assert.assertEquals(title_value, "Break Time");
                }
            }
            //Assert.assertEquals("title","Activity1");
        }

    }

    @AfterClass
    public void closedriver() {
        driver.quit();
    }
}
