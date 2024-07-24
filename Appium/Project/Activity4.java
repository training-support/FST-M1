package Appium_Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
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
    AndroidDriver driver;
    WebDriverWait wait;

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

        // Server Address
        URL serverURL = new URL("http://localhost:4723/");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Open the page in Chrome
        driver.get("https://v1.training-support.net/selenium");
    }
    @Test
    public void todoAdd() throws InterruptedException {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));


        //Adding First Task
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]")).click();
        Thread.sleep(100);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("Add tasks to list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
        //Adding Second Task
        //driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Input Events \uF11C Mouse click and Keyboard events\"]")).click();
        Thread.sleep(100);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("Get number of tasks");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
        //Adding Third Task
        //driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Input Events \uF11C Mouse click and Keyboard events\"]")).click();
        Thread.sleep(100);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("Clear the list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();

        //Assertions to check if the tasks are added.
        String taskText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Add tasks to list\"]")).getText();
        Assert.assertEquals(taskText, "Add tasks to list");
        taskText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Get number of tasks\"]")).getText();
        Assert.assertEquals(taskText, "Get number of tasks");
        taskText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Clear the list\"]")).getText();
        Assert.assertEquals(taskText, "Clear the list");

        //striking the tasks out
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Add tasks to list\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Get number of tasks\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Clear the list\"]")).click();

        //clearing all the tasks
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Clear List\"]")).click();

    }
}
