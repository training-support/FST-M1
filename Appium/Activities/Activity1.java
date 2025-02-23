package Activity;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.crypto.URIReferenceException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1Test {
	
	//Declare Appium driver
	AppiumDriver driver ;
	
	//Setup function
	@BeforeClass
	public void setUp() throws MalformedURLException ,URIReferenceException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.calculator");
		options.setAppActivity("com.android.calculator2.Calculator");
//		options.setApp("path/to/.apk");
		options.noReset();
		
		
		//Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();
			
		//Initialize the driver
		driver = new AndroidDriver(serverURL, options);
	}		
		//Test Function
		@Test
		public void multiplicationTest() {
			//Find digit 5 and tap it
			driver.findElement(AppiumBy.id("digit_5")).click();
			//Find plus symbol and tap it
			driver.findElement(AppiumBy.accessibilityId("multiply")).click();
			//Find digit 2 and tap it
			driver.findElement(AppiumBy.id("digit_2")).click();
			//Find equals symbol and tap it
			driver.findElement(AppiumBy.accessibilityId("equals")).click();
			
		//Assertions 
			String result = driver.findElement(AppiumBy.id("result_final")).getText();
			assertEquals(result,"10");
	}
	
		
		//Tear down function
		@AfterClass
		public void tearDown() {
			// Close the app
			
			driver.quit();
		}

}