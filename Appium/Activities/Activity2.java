import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {
    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options= new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("org.chromium.chrome.browser.ChromeTabbedActivity");
        options.noReset();

        URL serverURL= new URL("http://localhost:4723/");
        driver= new AndroidDriver(serverURL, options);
        driver.get("https://training-support.net/");
    }

    @Test
    public void chromeTest(){
        String headingText= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")).getText();
        System.out.println("Heading: "+headingText);
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='About Us']")).click();
        String aboutUsHeadingText= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).getText();
        System.out.println("About Us Page Heading: "+aboutUsHeadingText);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
