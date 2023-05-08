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

public class Activity3_Project {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        //Desired Capabilities
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        //Appium Server URL
        URL serverURL= new URL ("http://localhost:4723/wd/hub");

        //Driver Initialization
        driver=new AndroidDriver(serverURL,options);
        wait =new WebDriverWait(driver, Duration.ofSeconds(20));
        // Open the page in Chrome
        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void toDoList() throws InterruptedException {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));

        Thread.sleep(5000);
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        // Locate element
        driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text,'Elements get added at run time')]")).click();

        //wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@text,'To-Do List')]")));
        //driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text,'To-Do List')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.EditText")));
        WebElement input=driver.findElement(AppiumBy.className("android.widget.EditText"));
        input.click();
        input.sendKeys("Add tasks to list");
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text,'Add Task')]")).click();
        Thread.sleep(1000);
        input.click();
        Thread.sleep(1000);
        input.sendKeys("Get number of tasks");
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text,'Add Task')]")).click();
        Thread.sleep(1000);
        input.click();
        input.sendKeys("Clear the list");
        Thread.sleep(1000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text,'Add Task')]")).click();
        Thread.sleep(1000);

        WebElement task1= driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[2]/android.view.View"));
        String addedTask1=task1.getText();
        task1.click();
        Assert.assertEquals(addedTask1, "Add tasks to list");
        System.out.println("Task 1:"+addedTask1);
        WebElement task2= driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[3]/android.view.View"));
        String addedTask2=task2.getText();
        task2.click();
        Assert.assertEquals(addedTask2, "Get number of tasks");
        System.out.println("Task 2:"+addedTask2);
        WebElement task3= driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[4]/android.view.View"));
        String addedTask3=task3.getText();
        task3.click();
        Assert.assertEquals(addedTask3, "Clear the list");
        System.out.println("Task 3:"+addedTask3);
        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[3]/android.view.View[2]"));
        }
    @AfterClass
    public void teardown(){
        //Close the APP
        driver.quit();
    }
}
