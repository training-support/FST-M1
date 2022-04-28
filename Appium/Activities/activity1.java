package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class activity1 {
             //Driver Declarations
        AndroidDriver<MobileElement> driver;

        @BeforeClass
        public void setUp() throws MalformedURLException {
            //Desired Capabilities
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceId", "RZ8R81GKRSM");
            caps.setCapability("platformName", "android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
            caps.setCapability("appActivity", ".Calculator");
            caps.setCapability("noReset", true);

            //Appium server URL
            URL serverURL = new URL("http://localhost:4723/wd/hub");

            //Drvier Initialization
            driver = new AndroidDriver<>(serverURL, caps);
        }

        @Test
        public void MultiplyTest()
        {
            //Find 3 and click it
            driver.findElementById("calc_keypad_btn_07").click();
            //find + and click it
            driver.findElementById("calc_keypad_btn_multiply").click();
            //find 5 and click it
            driver.findElementById("calc_keypad_btn_05").click();
            //find 5 and click it
            driver.findElementById("calc_keypad_btn_equal").click();
            //get result and print
            String Result =driver.findElementById("calc_edt_formula").getText();
            System.out.println("Result is = " + Result);

            //Assertion
            Assert.assertEquals(Result,"35");
        }

        @AfterClass
        public void tearDown(){

            //Close the app

            driver.quit();
        }

    }


