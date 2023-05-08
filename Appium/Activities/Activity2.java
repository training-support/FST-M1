package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        //Desired Capabilities
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        //Appium Server URL
        URL serverURL= new URL ("http://localhost:4723/wd/hub");

        //Driver Initialization
        driver=new AndroidDriver(serverURL,options);
        wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        // Open the page in Chrome
        driver.get("https://www.training-support.net/");
    }

    @Test
    public void browserTest(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(
                        "//android.view.View[contains(@text,'Training Support')]")));
        String pageHeading = driver.findElement(AppiumBy.xpath(
                "//android.view.View[contains(@text,'Training Support')]")).getText();

        System.out.println("Heading: " + pageHeading);
        driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='about-link']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text='About Us']")));
        String aboutUs = driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']")).getText();
        System.out.println(aboutUs);
    }
    @AfterClass
    public void teardown(){
        //Close the APP
        driver.quit();
    }
}
