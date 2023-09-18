package Activities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class Activity4 {
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.contacts");
        options.setAppActivity(".PeopleActivityAlias");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }
    @Test
    public void addNewContact(){

        driver.findElement(AppiumBy.accessibilityId("New contact")).click();
        WebElement name=driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Name']"));
        WebElement phone=driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Number']"));
        WebElement saveBtn=driver.findElement(AppiumBy.accessibilityId("Save"));

        name.sendKeys("Aaditya Varma");
        phone.sendKeys("999148292");
        saveBtn.click();

        //wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("large_title")));
        WebElement savedContact=driver.findElement(AppiumBy.id("main_title"));
        assertEquals(savedContact.getText(),"Aaditya Varma","Contact was not saved!");
    }
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
