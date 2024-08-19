package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity1 {
    WebDriverWait wait;
    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test(priority = 1)
    public void addtask() {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"))).sendKeys("Complete Activity with Google Tasks");
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"))).sendKeys("Complete Activity with Google Keep");
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"))).sendKeys("Complete the second Activity Google Keep");
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done"))).click();

    }

    @Test(priority = 2)
    public void taskaddedvalidation() {
        boolean b = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/tasks_item_completed_check"))).isDisplayed();
        System.out.println(b);
        if (b == true) {
            List<WebElement> tasks = driver.findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_name"));
            for (WebElement task_list : tasks) {
                String tasks_list = task_list.getText();
                System.out.println(tasks_list);
                if (tasks_list.equalsIgnoreCase("Complete Activity with Google Tasks")) {
                    Assert.assertEquals(tasks_list, "Complete Activity with Google Tasks");
                } else if (tasks_list.equalsIgnoreCase("Complete Activity with Google Keep")) {
                    Assert.assertEquals(tasks_list, "Complete Activity with Google Keep");
                } else if (tasks_list.equalsIgnoreCase("Complete the second Activity Google Keep")) {
                    Assert.assertEquals(tasks_list, "Complete the second Activity Google Keep");
                }
            }
        }

    }

    @AfterClass
    public void quitdriver() {

        driver.quit();
    }
}
