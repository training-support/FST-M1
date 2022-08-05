import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;



public class Project_Activity3 
{


	 WebDriverWait wait;
	    AppiumDriver<MobileElement> driver = null;

	    @BeforeTest
	    public void setup() throws MalformedURLException 
	    {

	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "PixelEmulator");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.google.android.keep");
	        caps.setCapability("appActivity", ".activities.BrowseActivity");
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	        wait = new WebDriverWait(driver, 10);
	    }

	    @Test
	    public void addTitle() throws InterruptedException 
	    {
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    	MobileElement NewNoteButton =driver.findElementById("com.google.android.keep:id/new_note_button");
	    	NewNoteButton.click();
	    	System.out.println("Clicked on New Note Button");
	    	Thread.sleep(2000);	
	    	
	    	MobileElement NoteTitle = driver.findElementById("com.google.android.keep:id/editable_title");
	    	NoteTitle.sendKeys("My New Appium Note");
	    	String actual_noteTitle= NoteTitle.getText();
            System.out.println("The Note Title is" + actual_noteTitle);
            

	    	MobileElement NoteDescription = driver.findElementById("com.google.android.keep:id/edit_note_text");
	    	NoteDescription.sendKeys("This task is completed");
           
            driver.findElementById("com.google.android.keep:id/menu_switch_to_list_view").click();
            Thread.sleep(2000);
            driver.findElementById("com.google.android.keep:id/menu_text").click();
            Thread.sleep(2000);
            driver.findElementById("com.google.android.keep:id/date_spinner").click();
            Thread.sleep(1000);
            System.out.println("Clicked on Date picker");
            driver.findElementById("com.google.android.keep:id/reminder_date_tomorrow").click();
            Thread.sleep(2000);
            System.out.println("Date is Selected");
            driver.findElementById("com.google.android.keep:id/time_spinner").click();
            Thread.sleep(1000);
            System.out.println("Time Selection clicked ");
            driver.findElementById("com.google.android.keep:id/reminder_time_afternoon").click();
            Thread.sleep(2000);
            System.out.println("Time selected Succcessfully");
            driver.findElementById("com.google.android.keep:id/save").click();
            Thread.sleep(1000);
            System.out.println("Reminder is added successfully");
            
        	MobileElement BackButton =driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Navigate up']");
	    	BackButton.click();
	    	System.out.println("Back button is clicked and Note is saved");
	    	
	    	Thread.sleep(2000);
	    	
	    	List<MobileElement> Notes=driver.findElementsById("com.google.android.keep:id/browse_note_interior_content");
	    	int Size = Notes.size();
	        System.out.println("Total number of Notes present are" + Size);	
	        Thread.sleep(3000);
	    }

	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
	
	
}
