package Projects;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class GoogleTaskActivities {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();
        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,Duration.ofSeconds(3));
    }
    @Test
    public void addTasks() throws InterruptedException {
        List<String> taskList= new ArrayList<>();
        taskList.add("Complete Activity with Google Tasks");
        taskList.add("Complete Activity with Google Keep");
        taskList.add("Complete the second Activity Google Keep");

        for (String task:taskList) {
            driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
            Reporter.log("--Clicked on add new task--",true);

            driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys(task);
            driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
            Reporter.log("--Added task:"+task+"--",true);
        }
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.accessibilityId("Mark as complete"))));
        List<WebElement> addedLists=driver.findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_name"));
        assertEquals(addedLists.size(),3);
    }
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}

