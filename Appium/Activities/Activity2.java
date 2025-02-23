package Activity;


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

public class Activity2 {
	//Declare Appium driver
		AppiumDriver driver ;
		
		//Setup function
		@BeforeClass
		public void setUp() throws MalformedURLException ,URIReferenceException, URISyntaxException {
			// Desired Capabilities
			UiAutomator2Options options = new UiAutomator2Options();
			options.setPlatformName("android");
			options.setAutomationName("UiAutomator2");
			options.setAppPackage("com.android.chrome");
			options.setAppActivity("com.google.android.apps.chrome.Main");
//			options.setApp("path/to/.apk");
			options.noReset();
			
			
			//Server URL

			URL serverURL = new URI("http://localhost:4723").toURL();
				
			//Initialize the driver
			driver = new AndroidDriver(serverURL, options);
			
			// Open the browser with the URL- https://training-support.net
			driver.get("https://training-support.net");


		}		
			//Test Function
			@Test
			public void displayPageHeading() {

				// Locate heading on page and print it
				String pageTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")).getText();
				System.out.println("Heading: " + pageTitle);

		        // Find and click the About Us link
		        driver.findElement(AppiumBy.accessibilityId("About Us")).click();
		 
		        // Find heading of new page and print to console
		        String aboutPageHeading = driver.findElement(AppiumBy.xpath(
		                "//android.widget.TextView[@text='About Us']"
		        )).getText();
		        System.out.println(aboutPageHeading);
				

		}
		
						//Tear down function
			@AfterClass
			public void tearDown() {
				// Close the app
				
				driver.quit();
			}
}