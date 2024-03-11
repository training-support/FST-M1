package com.ibm.AppiumPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Activity5 {
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
 
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 2 API 30");
        caps.setCapability("platformName", "Android");
        caps.setCapability("noReset", true);
        caps.setCapability("appPackage", "com.google.android.apps.messaging");
        caps.setCapability("appActivity", ".ui.ConversationListActivity");
 
        

        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }
 
    @Test
    public void smsTest() {
        
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")));
        
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")).click();
 
       
        String contactBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";
 
        
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(contactBoxLocator)));
        driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("9014842678");
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        
        
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")));
 
        
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")).sendKeys("Hello from Appium");
 
        
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Send SMS\")")).click();
 
        
        String messageLocator = "resourceId(\"com.google.android.apps.messaging:id/message_text\")";
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(messageLocator)));
 
      
        String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
        Assert.assertEquals(sentMessageText, "Hello from Appium");
    }
 
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
