package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofMillis;
import static activities.ActionBase.doSwipe;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class Activity4 {
    WebDriverWait wait;
    AndroidDriver driver;
    ;
    int count = 0;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get("https://v1.training-support.net/selenium");
    }

    @Test(priority = 1)
    public void opentodo() throws InterruptedException {
        Dimension dims = driver.manage().window().getSize();
        Point start = new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.8));
        Point end = new Point((int) (dims.getWidth() * 0.3), (int) (dims.getHeight() * 0.1));
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
        doSwipe(driver, start, end, 1916);
        doSwipe(driver, start, end, 1916);
        doSwipe(driver, start, end, 1916);
        doSwipe(driver, start, end, 1916);
        boolean b = driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Training Support - Selenium']/android.view.View[2]/android.view.View[3]/android.view.View[15]")).isDisplayed();
        System.out.println(b);


        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.webkit.WebView[@text='Training Support - Selenium']/android.view.View[2]/android.view.View[3]/android.view.View[15]"))).click();

        //Whether the button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")));

        //Add task and click on button
        WebElement search = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"));
        WebElement Addtask = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));

        search.sendKeys("FirstActivity");
        Addtask.click();
        Thread.sleep(5000);
        search.sendKeys("SecondActivity");
        Addtask.click();
        Thread.sleep(5000);
        search.sendKeys("Third Activity");
        Addtask.click();
        Thread.sleep(5000);
        search.sendKeys("Fourth Activity");
        Addtask.click();
        Thread.sleep(5000);
        List<WebElement> tasks = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View/android.view.View"));
        //Get number of tasks
        int Get_number_of_tasks = tasks.size() - 1;
        System.out.println("Number of Tasks:" + Get_number_of_tasks);
        for (WebElement task : tasks) {
            String ActivityName = task.getText();
            task.click();
            Thread.sleep(3000);
            System.out.println(ActivityName);
        }
        //Clear the task
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@resource-id='tasksCard']/android.view.View[3]"))).click();
        Thread.sleep(3000);
        List<WebElement> No_of_task_now = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View"));
        //System.out.println(No_of_task_now.size());
        Thread.sleep(3000);
        System.out.println(No_of_task_now.size());
        Assert.assertEquals(No_of_task_now.size(), 0);
    }

    @AfterClass
    public void close() {
        driver.close();
    }

}
