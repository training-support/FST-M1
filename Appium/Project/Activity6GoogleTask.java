package LiveProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6GoogleTasks {
	// Driver Declaration
	AndroidDriver driver;
	WebDriverWait wait;
 
	// Set up method
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.tasks");
		options.setAppActivity(".ui.TaskListsActivity");
		options.noReset();
 
		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
 
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	
	@Test
	public void googleTasksTest() throws InterruptedException {
		driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
		driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
		driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
		driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
		Thread.sleep(1000);
		
		List <WebElement> tasksList = driver.findElements(AppiumBy.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.google.android.apps.tasks:id/tasks_list']/android.widget.FrameLayout"));
//		System.out.println("Size of the Task list is:" +tasksList.size());
		Assert.assertEquals(tasksList.size(), 3);
		
			//Reset the task list to 0
	        int task = 0;
	        while (task < tasksList.size()) {
	        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Mark as complete']")).click();
	            task++;
	        }
	}
	// Tear down method
	@AfterClass
	public void tearDown() {
		// Close the app
		driver.quit();
	}
}