package Appium_Selenium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Google_Tasks {
    //Driver Declarations
    AndroidDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "RZ8R81GKRSM");
        caps.setCapability("platf11ormName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        //Appium server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Driver Initialization
        driver = new AndroidDriver<>(serverURL, caps);
        wait = new WebDriverWait(driver,10);


    }

    @Test
    public void addTask() {
        //Find + and click on it
        driver.findElementById("tasks_fab").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
        driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Tasks");
       driver.findElementById("add_task_done").click();

        //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("task_fab")));
        driver.findElementById("task_fab").click();
        //driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Create new task\"]");

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
        driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
        driver.findElementById("add_task_done").click();
        driver.findElementById("task_fab").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
        driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
        driver.findElementById("add_task_done").click();
        driver.findElementById("task_fab").click();

        List<MobileElement> tasks = driver.findElementsById("task_name");
        String FirstTask = tasks.get(2).getText();
        String SecondTask = tasks.get(1).getText();
        String ThirdTask = tasks.get(0).getText();

        Assert.assertEquals(FirstTask,"Complete Activity with Google Tasks");
        Assert.assertEquals(SecondTask,"Complete Activity with Google Keep");
        Assert.assertEquals(ThirdTask,"Complete second Activity Google Keep");
    }
    @AfterClass
    public void tearDown(){

        //Close the app

        driver.quit();
    }
}

