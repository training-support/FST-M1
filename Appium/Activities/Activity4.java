package Activity;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import javax.xml.crypto.URIReferenceException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {
	//Declare Appium driver
		AppiumDriver driver ;
		WebDriverWait wait;
		
		//Setup function
		@BeforeClass
		public void setUp() throws MalformedURLException ,URIReferenceException, URISyntaxException {
			// Desired Capabilities
			UiAutomator2Options options = new UiAutomator2Options();
			options.setPlatformName("android");
			options.setAutomationName("UiAutomator2");
			options.setAppPackage("com.google.android.contacts");
			options.setAppActivity("com.google.android.apps.contacts.quickcontact.QuickContactActivity");
//			options.setApp("path/to/.apk");
			options.noReset();
			
			//Server URL
			URL serverURL = new URI("http://localhost:4723").toURL();
				
			//Initialize the driver
			driver = new AndroidDriver(serverURL, options);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}		
			//Test Function
			@Test
			public void addNewContact() {
				//Find and click the button to add a new contact.
				driver.findElement(AppiumBy.accessibilityId("Phone")).click();
				driver.findElement(AppiumBy.accessibilityId("Create new contact")).click();
				
				
		        // Wait for elements to load
		        wait.until(ExpectedConditions.elementToBeClickable(
		                AppiumBy.xpath("//android.widget.EditText[@text='First name']")
		        ));
				
				driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Aaditya");
				driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("Varma");
				driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("999148292");
				driver.findElement(AppiumBy.id("com.google.android.contacts:id/toolbar_button")).click();
				
				
				//Assertions 
				
		        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("large_title")));
		 
		        // Assertion
		        String contactName = driver.findElement(AppiumBy.id("large_title")).getText();
		        Assert.assertEquals(contactName, "Aaditya Varma");
		}
		
			
			//Tear down function
			@AfterClass
			public void tearDown() {
				// Close the app
				
				driver.quit();
			}
			
}