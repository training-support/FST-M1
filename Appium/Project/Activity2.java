package project_appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {

    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void addTasks() throws InterruptedException {
        String noteTitle = "Sample notes";
        String descriptionText = "Sample description added for reference";
        By title = AppiumBy.id("index_note_title");

        //  task addition & assertions
        driver.findElement(AppiumBy.id("new_note_button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("editable_title"))).sendKeys(noteTitle);
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys(descriptionText);
        driver.findElement(AppiumBy.className("android.widget.ImageButton")).click();
        Assert.assertEquals(driver.findElement(title).getText(), noteTitle);
        Assert.assertEquals(driver.findElement(AppiumBy.id("index_note_text_description")).getText(), descriptionText);

    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}