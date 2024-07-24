package Examples;

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


public class Activity4
{
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.contacts");
        options.setAppActivity("com.google.android.apps.contacts.editor.ContactEditorActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Test method
    @Test
    public void contactsTest() {
        // Find and click the add button
        driver.findElement(AppiumBy.accessibilityId("Contacts")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.contacts:id/floating_action_button")));
        driver.findElement(AppiumBy.id("com.google.android.contacts:id/floating_action_button")).click();
        // Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.EditText[@text=\"First name\"]")
        ));

        // Enter the details
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text=\"First name\"]"
        )).sendKeys("Sreevara");
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text=\"Last name\"]"
        )).sendKeys("Mysore");
        driver.findElement(AppiumBy.xpath(
                "//android.widget.EditText[@text=\"Phone\"]"
        )).sendKeys("9448488175");
        // Click Save
        driver.findElement(AppiumBy.id("com.google.android.contacts:id/toolbar_button")).click();

        // Wait for contact to save
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.contacts:id/large_title")));

        // Assertion
        String contactName = driver.findElement(AppiumBy.id("com.google.android.contacts:id/large_title")).getText();
        Assert.assertEquals(contactName, "Sreevara Mysore");
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
