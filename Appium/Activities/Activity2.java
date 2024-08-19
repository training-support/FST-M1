package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set the desired capabilities
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UIAutomator2")
                .setAppPackage("com.android.chrome")
                .setAppActivity("com.google.android.apps.chrome.Main")
                .noReset();

        //Set the appium severURL
        URL serverUrl= new URL("http://localhost:4723/wd/hub");

        //Initialize the android driver
        driver = new AndroidDriver(serverUrl, caps);
        driver.get("https://training-support.net/");
    }

    @Test
    public void verifyAboutUs(){
        String pageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text='Training Support']")).getText();
        System.out.println("Heading:  "+pageHeading);
        driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']")).click();
        String aboutPageHeading = driver.findElement(AppiumBy.xpath(
                "//android.view.View[@text='About Us']"
        )).getText();
        System.out.println(aboutPageHeading);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
