package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
        caps.setCapability("deviceName", "Pixel 4 API 28");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", ".activities.BrowseActivity");
        caps.setCapability("appActivity", "com.google.android.keep");
        caps.setCapability("noReset", true);
 
        
        
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }
    
    @Test
	 public void testSearchAppium() {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	     driver.get("https://www.training-support.net/selenium");
	
	
	     MobileElement aboutButton = driver.findElementByClassName("android.widget.Button");
	     aboutButton.click();
	
	     driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"To-Do List\")"));
	     driver.findElementByClassName("android.view.View").click();
	     
	     driver.findElementByClassName("android.widget.EditText").sendKeys("Task1");
	     driver.findElementByClassName("android.widget.Button").click();
	     
	     driver.findElementByClassName("android.widget.EditText").sendKeys("Task2");
	     driver.findElementByClassName("android.widget.Button").click();
	     
	     driver.findElementByClassName("android.widget.EditText").sendKeys("Task3");
	     driver.findElementByClassName("android.widget.Button").click();
	     
	    List<MobileElement> numberOfTask = driver.findElementsByClassName("android.view.View");
	    System.out.println("Number of taks shown currently: " + numberOfTask.size());
	    
	    driver.findElementByClassName("android.view.View").click();
	    
	    for(MobileElement ele:numberOfTask)
	    {
	    	ele.findElementByClassName("android.view.View").click();
	    }
	    
	    driver.findElementByClassName("android.view.View").click();
	 }
	
		 @AfterTest
		 public void tearDown() {
		     driver.quit();
	 }

}
