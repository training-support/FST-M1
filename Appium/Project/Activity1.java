package project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeTest
	public void setup() throws MalformedURLException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void useGoogleTaskApp() throws InterruptedException {
		String[] tasks = { "Complete Activity with Google Tasks", "Complete Activity with Google Keep",
				"Complete the second Activity Google Keep" };

		for (String task : tasks) {
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
			driver.findElementById("tasks_fab").click();
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
			driver.findElementById("add_task_title").sendKeys(task);
			driver.findElementById("add_task_done").click();
		}
		wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.id("task_name"), 3));
		List<MobileElement> taskadded = driver.findElementsById("task_name");
		assertEquals(taskadded.size(), 3);
		assertEquals(taskadded.get(2).getText(), "Complete Activity with Google Tasks");
		assertEquals(taskadded.get(1).getText(), "Complete Activity with Google Keep");
		assertEquals(taskadded.get(0).getText(), "Complete the second Activity Google Keep");

	}
	@AfterTest
    public void afterClass() {
        driver.quit();
    }
}
