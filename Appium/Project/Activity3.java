package Project;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3 {
	AppiumDriver<MobileElement> driver = null;
	 
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 28");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", ".activities.BrowseActivity");
        caps.setCapability("appActivity", "com.google.android.keep");
        caps.setCapability("noReset", true);
 
        
        
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }
    
    @Test
	 public void addNoteWithReminder() {
   	MobileElement taskbtn = driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Keep Notes\"]");
   	taskbtn.click();
   	driver.findElementById("com.google.android.keep:id/notes").click();
   	driver.findElementById("com.google.android.keep:id/browse_note_interior_content").sendKeys("Title1");
   	driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Description1");
   	driver.findElementById("com.google.android.keep:id/editor_bottom_bar").click();
   	driver.findElementById("com.google.android.keep:id/menu_switch_to_list_view").click();
   	
   	driver.findElementByClassName("android.widget.LinearLayout").click();
   	driver.findElementByClassName("android.widget.TextView").click();
   	driver.findElementById("com.google.android.keep:id/save").click();
   	
   	driver.findElementById("com.google.android.keep:id/editor_bottom_bar").click();
   	driver.findElementById("com.google.android.keep:id/editor_bottom_bar").click();
   	
   	String rem = driver.findElementById("com.google.android.keep:id/reminder_chip_text").getText();
   	Assert.assertEquals(rem, "Today, 8.:30 PM");
    }
    
    @AfterTest
	 public void tearDown() {
	     driver.quit();
	 }

}
