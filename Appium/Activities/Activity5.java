package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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

import static org.testng.Assert.assertEquals;

public class Activity5 {
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.mms");
        options.setAppActivity(".ui.ConversationList");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void smsTest(){
        driver.findElement(AppiumBy.accessibilityId("Start new conversation")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("recipient_text_view")));
        driver.findElement(AppiumBy.id("recipient_text_view")).sendKeys("9495885406");
        driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
        driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");
        driver.findElement(AppiumBy.accessibilityId("Send message")).click();
        WebElement sentMessage=driver.findElement(AppiumBy.id("message_text"));
        wait.until(ExpectedConditions.visibilityOf(sentMessage));
        assertEquals(sentMessage.getText(),"Hello from Appium");
    }

    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
