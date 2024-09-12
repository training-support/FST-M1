package project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity3 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.google.android.keep")
                .setAppActivity(".activities.BrowseActivity")
                .noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void addNoteReminder() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/edit_note_text")));
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Complete Activity with Google Keep");
        Thread.sleep(5000);
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Activity");
        driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Pick a date & time\"]")).click();
        driver.findElement(AppiumBy.id("com.google.android.keep:id/time_spinner")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/text\" and @text=\"Afternoon\"]")).click();
        driver.findElement(AppiumBy.id("com.google.android.keep:id/save")).click();
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/browse_note_interior_content")));
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("com.google.android.keep:id/index_note_title")).getText(), "Activity");
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("com.google.android.keep:id/index_note_text_description")).getText(), "Complete Activity with Google Keep");
        Assert.assertEquals(driver.findElement(AppiumBy.xpath("com.google.android.keep:id/reminder_chip_text")).getText(), "Today, 1:00 PM");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
