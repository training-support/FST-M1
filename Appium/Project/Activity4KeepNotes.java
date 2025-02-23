package LiveProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4KeepNotes {
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
		options.setAppPackage("com.google.android.keep");
		options.setAppActivity(".activities.BrowseActivity");
		options.noReset();
 
		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
 
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	
	@Test
	public void googleKeepTest() throws InterruptedException {
		driver.findElement(AppiumBy.id("com.google.android.keep:id/speed_dial_create_close_button")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("com.google.android.keep:id/new_note_button")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Note1");
		driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("This is a test Note");
		
		//Return back
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		String actuaNote = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title")).getText();
		Assert.assertTrue(actuaNote.contains("Note1"));
		
		//Remove the added note to make it work for the next time
		driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("com.google.android.keep:id/editor_action_button")).click();
		Thread.sleep(5000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Delete\")")).click();
		Thread.sleep(2000);
	}
	// Tear down method
	@AfterClass
	public void tearDown() {
		// Close the app
		driver.quit();
	}
}