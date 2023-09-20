package project_appium;

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
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page in Chrome
        driver.get("https://www.training-support.net/selenium");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void addTasks() throws InterruptedException {

        String tasks[] = new String[3];
        tasks[0] = "Add tasks to list";
        tasks[1] = "Get number of tasks";
        tasks[2] = "Clear the list";

        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));

        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        Thread.sleep(2000);
        
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")));

        for (int i = 0; i < 3; i++) {
            driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(tasks[i]);
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        }
        for (int j = 0; j < 3; j++) {
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + tasks[j] + "']")).click();
        }

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=' Clear List']")).click();
        Assert.assertTrue(driver.findElements(AppiumBy.id("tasksList")).size() == 0);

    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}