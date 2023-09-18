package Projects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class GoogleKeepActivities {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();
        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    @Test
    public void addNote() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("New Title - Test");
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("New Note - Test");
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        String title=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='New Title - Test']")).getText();
        String note=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='New Note - Test']")).getText();
        assertEquals(title,"New Title - Test");
        assertEquals(note,"New Note - Test");
    }
}
