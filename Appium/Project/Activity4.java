package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity4 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);

		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 5);

		driver.get("https://www.training-support.net/selenium");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingToEnd(5)"));
		driver.findElementByXPath("//android.view.View[contains(@text,'To-Do List')]").click();
	}

	@Test
	public void todo() {
		String[] tasks = { "Add tasks to list", "Get number of tasks", "Clear the list" };
		for (String task : tasks) {
			driver.findElementByXPath("//android.widget.EditText[@resource-id = 'taskInput']").click();
			driver.findElementByXPath("//android.widget.EditText[@resource-id = 'taskInput']").sendKeys(task);
			driver.findElementByXPath("//android.widget.Button[@text = 'Add Task']").click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		driver.findElementByXPath("//android.view.View[@text='Add tasks to list']").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.view.View[@text='Get number of tasks']").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.view.View[@text='Clear the list']").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.view.View[3][@class='android.view.View']").click();
		}
	@AfterTest
	public void afterClass() {
		driver.quit();
	}
	

}
