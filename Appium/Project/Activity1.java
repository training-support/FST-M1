package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {
	AppiumDriver<MobileElement> driver = null;
	 
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 28");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", ".ui.TaskListsActivity");
        caps.setCapability("appActivity", "com.google.android.apps.tasks");
        caps.setCapability("noReset", true);
 
        
        
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }
    
    @Test
	 public void createListOfActivities() {
    	MobileElement taskbtn = driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Tasks\"]");
    	taskbtn.click();
    	driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Create new task\"]").click();
    	driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Tasks");
    	driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
    	
    	driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Keep");
    	driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
    	
    	driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete the second Activity Google Keep");
    	driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
    	
    	String task1 = driver.findElementById("com.google.android.apps.tasks:id/task_name").getText();
    	Assert.assertEquals(task1, "Complete Activity with Google Tasks");
    	
    	String task2 = driver.findElementById("com.google.android.apps.tasks:id/task_name").getText();
    	Assert.assertEquals(task2, "Complete Activity with Google Keep");
    	
    	String task3 = driver.findElementById("com.google.android.apps.tasks:id/task_name").getText();
    	Assert.assertEquals(task3, "Complete the second Activity Google Keep");
    }
		 @AfterTest
		 public void tearDown() {
		     driver.quit();
	 }

}
