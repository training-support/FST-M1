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


public class Activity3
{
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



    }

    @Test
    public void addingAndUpdatingTasks() throws InterruptedException
    {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Keep Notes\"]")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"New text note\"]")).click();
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Tester");
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Some Text");
        driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
        Thread.sleep(300);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Later today\"]")).click();
        Thread.sleep(200);
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        Thread.sleep(600);
        String message = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Time reminder Today, 6:00 PM\"]")).getText();
        Assert.assertEquals(message,"Today, 6:00 PM");
    }


}
