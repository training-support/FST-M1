package AppiumProjectActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoogleActivity1 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "PixelEmulator");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void googleTasks() throws InterruptedException {
    	Thread.sleep(5000);
       //driver.findElementById("com.google.android.apps.tasks:id/welcome_get_started").click();
    	MobileElement CreateNewTaskButton= driver.findElement(MobileBy.AccessibilityId("Create new task"));
    	CreateNewTaskButton.click();
    	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='New task']")));
    	System.out.println("New Task textbox is opened- Enter all the tasks now!!");
    	MobileElement Tasks=driver.findElementByXPath("//android.widget.EditText[@text='New task']");
    	Tasks.sendKeys("Complete Activity with Google Tasks");
    	MobileElement Task1=Tasks;
    	System.out.println("Task1- "+Task1.getText());
    	MobileElement Save= driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_done"));
    	Save.click();
    	
    	Thread.sleep(2000);
    	CreateNewTaskButton.click();
    	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='New task']")));
    	Tasks.sendKeys("Complete Activity with Google Keep");
    	MobileElement Task2=Tasks;
    	System.out.println("Task2- "+Task2.getText());
    	Save.click();
    	
    	Thread.sleep(2000);
    	CreateNewTaskButton.click();
    	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='New task']")));
    	Tasks.sendKeys("Complete the second Activity Google Keep");
    	MobileElement Task3=Tasks;
    	System.out.println("Task3- "+Task3.getText());
    	Save.click();
    	
    	wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"My Tasks\"]/android.widget.TextView")));
    	List<MobileElement> tasksList = driver.findElementsById("com.google.android.apps.tasks:id/task_item_layout");
        System.out.println("Number of tasks in the list: " + tasksList.size());
     
        Assert.assertEquals(tasksList.size(), 3);
        
        for (MobileElement i : tasksList)
        {
        	System.out.println("Tasks- "+i.getAttribute("content-desc"));
        }
        
//        Assert.assertTrue(tasksList.contains(Task1));
//        Assert.assertTrue(tasksList.contains(Task2));
//        Assert.assertTrue(tasksList.contains(Task3));
        
    }

    @AfterClass
    public void afterClass() {
       // driver.quit();
    }
}
