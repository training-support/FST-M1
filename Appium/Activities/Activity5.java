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

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;



public class Activity5
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
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".ui.ConversationListActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Test method
    @Test
    public void smsTest() throws InterruptedException {
        // Find and click the add button
        driver.findElement(AppiumBy.accessibilityId("Messages")).click();

        // Wait for elements to load
        Thread.sleep(15);
        //wait.until(ExpectedConditions.elementToBeClickable(
          //      AppiumBy.id("(//android.widget.ImageView[@resource-id=\"com.google.android.apps.messaging:id/conversation_icon\"])[1]")
            //    ));

        Thread.sleep(15);
        // Find the element to add recipient
        //driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/zero_state_search_box_auto_complete")).sendKeys("9986607406");
        //driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/contact_icon")).click();
        // Press ENTER
        //driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));

        // Wait for textbox to appear
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.messaging:id/compose_message_text")));

        // Enter text to send
        Thread.sleep(13);
        driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/compose_message_text")).sendKeys("Hello from Appium");
        // Press Send
        //Thread.sleep(15);
        driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/send_message_button_icon")).click();


        // Assertion
        String messageTextSent = driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/message_text")).getText();
        Assert.assertEquals(messageTextSent, "Hello from Appium");
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
