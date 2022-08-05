import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Project_Activity1 {

	 WebDriverWait wait;
	    AppiumDriver<MobileElement> driver = null;

	    @BeforeTest
	    public void setup() throws MalformedURLException 
	    {

	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "PixelEmulator");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.google.android.apps.tasks");
	        caps.setCapability("appActivity", ".ui.TaskListsActivity");
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	        wait = new WebDriverWait(driver, 10);
	    }

	    @Test
	    public void clickOnAddTaskButton() throws InterruptedException 
	    {
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    	MobileElement AddTaskButton =driver.findElementById("com.google.android.apps.tasks:id/tasks_fab");
	    	AddTaskButton.click();
	    	System.out.println("Clicked on Add Icon");
	    	Thread.sleep(2000);	
	    	
	    	MobileElement TaskName = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
	    	TaskName.sendKeys("Complete Activity With Google Tasks");
	        MobileElement TaskDone=	driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
	        TaskDone.click();
	        System.out.println("First Task is added");
	        Thread.sleep(2000);
	 
	        
	        AddTaskButton.click();
	        Thread.sleep(2000);
	        driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Keep");
	      
	        TaskDone.click();
	        System.out.println("Second Task is added");
	        Thread.sleep(3000);
	        
	        AddTaskButton.click();
	        Thread.sleep(2000);
	        driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete the second Activity Google Keep");
	        TaskDone.click();
	        System.out.println("Third Task is added");
	        Thread.sleep(2000);
	     
	    }

	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
}
