package activities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class activity3 {

        WebDriverWait wait;
        AndroidDriver<MobileElement> driver;

        @BeforeTest
        public void setup() throws MalformedURLException {
            // Set the Desired Capabilities
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", "RZ8R81GKRSM");
            caps.setCapability("platformName", "android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
            caps.setCapability("appActivity", ".Calculator");
            caps.setCapability("noReset", true);

            // Instantiate Appium Driver
            driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
            wait = new WebDriverWait(driver, 10);
        }
        @Test
    public void Addition()
    {
        //Find 3 and click it
        driver.findElementById("calc_keypad_btn_05").click();
        //find + and click it
        driver.findElementById("calc_keypad_btn_add").click();
        //find 5 and click it
        driver.findElementById("calc_keypad_btn_09").click();
        //find 5 and click it
        driver.findElementById("calc_keypad_btn_equal").click();
        //get result and print
        String Result =driver.findElementById("calc_edt_formula").getText();
        System.out.println("Addition is  = " + Result);

        //Assertion
        Assert.assertEquals(Result,"14");
    }

    @Test
    public void Subtraction()
    {
        //Find 3 and click it
        driver.findElementById("calc_keypad_btn_10").click();
        //find + and click it
        driver.findElementById("calc_keypad_btn_subtract").click();
        //find 5 and click it
        driver.findElementById("calc_keypad_btn_05").click();
        //find 5 and click it
        driver.findElementById("calc_keypad_btn_equal").click();
        //get result and print
        String Result =driver.findElementById("calc_edt_formula").getText();
        System.out.println("Addition is  = " + Result);

        //Assertion
        Assert.assertEquals(Result,"5");
    }

    @Test
    public void Multiplication()
    {
        //Find 3 and click it
        driver.findElementById("calc_keypad_btn_5").click();
        //find + and click it
        driver.findElementById("calc_keypad_btn_multiply").click();
        //find 5 and click it
        driver.findElementById("calc_keypad_btn_100").click();
        //find 5 and click it
        driver.findElementById("calc_keypad_btn_equal").click();
        //get result and print
        String Result =driver.findElementById("calc_edt_formula").getText();
        System.out.println("Addition is  = " + Result);

        //Assertion
        Assert.assertEquals(Result,"500");
    }

    @Test
    public void Divide()
    {
        //Find 3 and click it
        driver.findElementById("calc_keypad_btn_50").click();
        //find + and click it
        driver.findElementById("calc_keypad_btn_devide").click();
        //find 5 and click it
        driver.findElementById("calc_keypad_btn_2").click();
        //find 5 and click it
        driver.findElementById("calc_keypad_btn_equal").click();
        //get result and print
        String Result =driver.findElementById("calc_edt_formula").getText();
        System.out.println("Addition is  = " + Result);

        //Assertion
        Assert.assertEquals(Result,"25");
    }
    @AfterTest
    public void tearDown() {

        driver.quit();
    }
}
