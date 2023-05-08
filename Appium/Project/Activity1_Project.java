package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
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

public class Activity1_Project {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        //Desired Capabilities
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        //Appium Server URL
        URL serverURL= new URL ("http://localhost:4723/wd/hub");

        //Driver Initialization
        driver=new AndroidDriver(serverURL,options);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void googleTask(){
        //Task 1
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        WebElement task_title=driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"));
        task_title.click();
        task_title.sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/task_data")));
        WebElement task_added=driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/task_name"));
        System.out.println(task_added.getText());
        assertEquals(task_added.getText(),"Complete Activity with Google Tasks");

        //Task 2
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        WebElement task_title1=driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"));
        task_title1.click();
        task_title1.sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/task_data")));
        WebElement task_added1=driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/task_name"));
        System.out.println(task_added1.getText());
        assertEquals(task_added1.getText(),"Complete Activity with Google Keep");

        //Task 3
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        WebElement task_title2=driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"));
        task_title2.click();
        task_title2.sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/task_data")));
        WebElement task_added3=driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/task_name"));
        System.out.println(task_added3.getText());
        assertEquals(task_added3.getText(),"Complete the second Activity Google Keep");
    }

    @AfterClass
    public void teardown(){
        //Close the APP
        driver.quit();
    }
}
