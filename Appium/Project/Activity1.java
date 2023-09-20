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

public class Activity1 {

    // Driver Declaration
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public void addTasks() throws InterruptedException {
        String tasks[] = new String[3];
        tasks[0] = "Complete Activity with Google Tasks";
        tasks[1] = "Complete Activity with Google Keep";
        tasks[2] = "Complete the second Activity Google Keep";

        // task addition & assertions
        By title = AppiumBy.id("add_task_title");

        for (int i = 0; i < 3; i++) {
            driver.findElement(AppiumBy.id("tasks_fab")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.presenceOfElementLocated(title)).sendKeys(tasks[i]);
            driver.findElement(AppiumBy.id("add_task_done")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("task_name")));
            String res = driver.findElement(AppiumBy.id("task_name")).getText();
            Assert.assertEquals(res, tasks[i]);
        }

    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}