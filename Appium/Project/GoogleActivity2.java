package AppiumProjectActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoogleActivity2 {

	AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "PixelEmulator");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void googleKeep() throws InterruptedException {
    	MobileElement CreateNewNote= driver.findElement(MobileBy.AccessibilityId("New text note"));
    	CreateNewNote.click();
    	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/browse_note_interior_content")));
        MobileElement noteTitle=driver.findElement(MobileBy.id("com.google.android.keep:id/editable_title"));
        noteTitle.click();
        noteTitle.sendKeys("Title for the new note");
        String noteTitleInfo=noteTitle.getText();
        MobileElement noteInfo=driver.findElement(MobileBy.id("com.google.android.keep:id/edit_note_text"));
        noteInfo.click();
        noteInfo.sendKeys("This note is for writing the Google Keep Program");
        System.out.println("Information entered now go back to verify the notes details");
        driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
        
      List<MobileElement> notesList=driver.findElements(MobileBy.id("com.google.android.keep:id/browse_text_note"));
      System.out.println("size: "+notesList.size());
      for (MobileElement i : notesList)
      {
    	  if(i.getAttribute("content-desc").contains(noteTitleInfo))
    			  {
    		  		System.out.println("Notes List contains the created new note: "+noteTitleInfo);
    			  }
      }
    }

    @AfterClass
    public void afterClass() {
       driver.quit();
    }
	
}
