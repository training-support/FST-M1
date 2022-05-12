package Appium_Selenium;

import io.appium.java_client.MobileBy;
        import io.appium.java_client.MobileElement;
        import io.appium.java_client.android.AndroidDriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;

        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.List;


public class Chrome_ToDo {
    //Driver Declarations
    AndroidDriver<MobileElement> driver = null;
    WebDriverWait wait;

   @BeforeClass
    public void setup() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "RZ8R81GKRSM");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
        // Open page
        driver.get("https://www.training-support.net/selenium");


    }


    @Test
    public void scrollIntoViewTest() {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));

        // Scroll element into view and click it
        driver.findElement(
                        MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(7).scrollIntoView(text(\"To-Do List\"))"))
                .click();


        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.EditText")));
        driver.findElementByClassName("android.widget.EditText").sendKeys("Activity1");
        

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.Button")));
        driver.findElementByClassName("android.widget.Button").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.EditText")));
        driver.findElementByClassName("android.widget.EditText").sendKeys("Activity2");

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.Button")));
        driver.findElementByClassName("android.widget.Button").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.TextView")));
        driver.findElementByClassName("android.widget.TextView").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.TextView")));
        driver.findElementByClassName("android.widget.TextView").click();

        String FirstValue =driver.findElementByClassName("android.widget.TextView").getText();
        Assert.assertEquals(FirstValue,"Activity1");



    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
