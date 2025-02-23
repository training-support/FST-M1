package LiveProject;



import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3ToDoList {
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		// Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Open Selenium page
		driver.get("https://v1.training-support.net/selenium");
	}

	@Test(priority=1)
	public void toDoList() throws InterruptedException {
		// Wait for page to load
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='Selenium']")));
		// UiScrollable object string
		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		
		// Scroll to required element
		 driver.findElement(AppiumBy
		.androidUIAutomator(UiScrollable + ".scrollForward(4).getChildByText(className(\"android.view.View\"), \"To-Do List\")"));
		//Thread.sleep(10000);
		driver.findElement(AppiumBy.xpath("	\r\n"
				+ "//android.widget.TextView[@text='To-Do List']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText")));
		WebElement taskInputBox = driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText"));
		WebElement addTaskBtn = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]"));
		
		//Add the below 3 tasks
		taskInputBox.sendKeys("Add tasks to list");
		addTaskBtn.click();
		taskInputBox.sendKeys("Get number of tasks");
		addTaskBtn.click();
		taskInputBox.sendKeys("Clear the list");
		addTaskBtn.click();
		
		//Click on the tasks to strike them out
		List<WebElement> tasksList = driver.findElements(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View"));
	//	System.out.println("size of list is : " +(tasksList.size()-1));
	    for (int i = 0; i < tasksList.size(); i++) {
	        WebElement task = tasksList.get(i);
	        task.click();
//	        Thread.sleep(10000);
	    }
		
	
		//clear the list.
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Clear List\"]")).click();
	Thread.sleep(10000);
		
	
	List<WebElement> tasksListNew = driver.findElements(AppiumBy.xpath("//android.webkit.WebView[@text=\"Todo List\"]/android.view.View/android.view.View"));
		//Check if the number of tasks is zero
//	System.out.println("size of new list is : " +(tasksListNew.size()-1));
		Assert.assertEquals((tasksListNew.size()-1), 0);
	}


	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}


}