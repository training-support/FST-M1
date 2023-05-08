package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Activity2_Project {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        //Desired Capabilities
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        //Appium Server URL
        URL serverURL= new URL ("http://localhost:4723/wd/hub");

        //Driver Initialization
        driver=new AndroidDriver(serverURL,options);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void googleKeepTest(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"New text note\"]")));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"New text note\"]")).click();
        WebElement title= driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title"));
        title.click();
        title.sendKeys("AppiumProject");
        WebElement note= driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text"));
        note.click();
        note.sendKeys("Activity2");
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/index_note_title")));
        String note1= driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title")).getText();
        System.out.println(note1);
        assertEquals(note1,"AppiumProject");
    }

    @AfterClass
    public void teardown(){
        //Close the APP
        driver.quit();
    }
}
