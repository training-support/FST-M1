package Appium_Selenium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class Google_Keep {
    //Driver Declarations
    AndroidDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "RZ8R81GKRSM");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        //Appium server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Driver Initialization
        driver = new AndroidDriver<>(serverURL, caps);
        wait = new WebDriverWait(driver,20);
    }

    @Test
    public void addValue() {
        //Find + and click on it
        //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"Add\"]")));
        //driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Add\"]").click();
       // wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("notes")));
        //driver.findElementById("notes").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_notes")));
        driver.findElementById("add_notes").sendKeys("Complete Activity with Google Tasks");
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("edit_note_text")));
        driver.findElementById("edit_note_text").sendKeys("Complete Activity with Google Tasks");




        String FirstValue =driver.findElementById("index_note_title").getText();
        String DescValue =driver.findElementById("index_note_text_description").getText();

        Assert.assertEquals(FirstValue,"Google Keep");
        Assert.assertEquals(DescValue,"Google Keep Description");
    }



@AfterClass
public void tearDown(){

        //Close the app

        driver.quit();
        }
        }