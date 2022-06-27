package AppiumProjectActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoogleActivity3 {

	AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "PixelEmulator");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void googleChrome() throws InterruptedException {
        // Scroll element into view and click it
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(5).scrollIntoView(new UiSelector().textContains(\"To-Do List\"))")).click();      
// Method1 (sometimes did not work)-
//		driver.findElement(MobileBy.AndroidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward(8).scrollIntoView(new UiSelector().textContains(\"To-Do List\"))")).click();      
// Method2-    	
//    	driver.findElement(MobileBy.AndroidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(5)"));
//    	driver.findElement(MobileBy.xpath("//android.view.View[contains(@text, 'To-Do List')]")).click();
        
        Thread.sleep(3000);       
        MobileElement ClearListButton=driver.findElement(MobileBy.xpath("//android.view.View[4]/android.view.View[3]/android.view.View[2]"));
        ClearListButton.click();
        
        Thread.sleep(3000);
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")"));
        MobileElement taskbox= driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")"));
        taskbox.click();
        taskbox.sendKeys("Add tasks to list");
        MobileElement AddTask=driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Add Task']"));
        AddTask.click();
        
        Thread.sleep(3000);
        taskbox.click();
        taskbox.sendKeys("Get number of tasks");
        AddTask.click();

        Thread.sleep(3000);
        taskbox.click();
        taskbox.sendKeys("Clear the list");
        Thread.sleep(5000);
        String Task3=taskbox.getText();
        AddTask.click();
        
        Thread.sleep(2000);
        List<MobileElement> tasksListData=driver.findElements(MobileBy.xpath("//android.view.View[4]/android.view.View[2]/android.view.View/android.view.View"));
        System.out.println("size: "+tasksListData.size());
        for (MobileElement i : tasksListData)
        {
        	System.out.println("Tasks to select: "+i.getText());
        } 
               
        Thread.sleep(5000);
        List<MobileElement> tasksList=driver.findElements(MobileBy.xpath("//android.view.View[4]/android.view.View[2]/android.view.View"));
        System.out.println("size: "+tasksList.size());
        for (MobileElement i : tasksList)
        {     	  
      		Thread.sleep(2000);
      		i.click();
      		Thread.sleep(2000);
        }
        System.out.println("All Tasks are striked out");
        ClearListButton.click();
    }

    @AfterClass
    public void afterClass() {
       driver.quit();
    }
	
}
