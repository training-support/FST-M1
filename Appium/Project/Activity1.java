package Appium_Project;

import com.beust.ah.A;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.opentelemetry.api.baggage.propagation.W3CBaggagePropagator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;



public class Activity1
{
    // Driver Declaration
    AndroidDriver driver;

    // Setting up
    @BeforeClass
    public void setUp() throws MalformedURLException
    {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");

        // Server Address
        URL serverURL = new URL("http://localhost:4723/");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);

        //Swipping

    }

    @Test
    public void addingAndUpdatingTasks() throws InterruptedException {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Keep Notes\"]")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"New text note\"]")).click();
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Tester");
        //driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("This is the text coming from Appium for Notes");
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Some Text");
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        //driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Archive\"]")).click();
        String message = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/index_note_title\" and @text=\"Tester\"]")).getText();
        //Assertion for Keep
        //String message = driver.findElement(AppiumBy.id("com.google.android.keep:id/snackbar_text")).getText();
        Assert.assertEquals(message,"Tester");
    }


}
