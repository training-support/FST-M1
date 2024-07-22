package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity3 {
    WebDriverWait wait;
    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test(priority = 1)
    public void addnote() {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/new_note_button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/editable_title"))).sendKeys("Lunch Time");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/edit_note_text"))).sendKeys("its lunch time now");
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/menu_reminder"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.keep:id/menu_text"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Navigate up"))).click();

        boolean b = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/index_note_title"))).isDisplayed();
        System.out.println(b);
        if (b == true) {
            List<WebElement> titles = driver.findElements(AppiumBy.id("com.google.android.keep:id/index_note_title"));
            for (WebElement title : titles) {
                String title_value = title.getText();
                List<WebElement> reminders = driver.findElements(AppiumBy.id("com.google.android.keep:id/reminder_chip_text"));
                for (WebElement reminder_list : reminders) {
                    String re = reminder_list.getText();
                    if (title_value.equalsIgnoreCase("Lunch Time") && re.equalsIgnoreCase("Today, 6:00 PM")) {
                        System.out.println(re);
                        System.out.println(title_value);
                        Assert.assertEquals(title_value, "Lunch Time");
                        Assert.assertEquals(re, "Today, 6:00 PM");
                        System.out.println("Title with Reminder Exists");
                        break;
                    }

                }
            }
        }
        //Assert.assertEquals("title","Activity1");
    }

    @AfterClass
    public void close() {
        driver.quit();
    }


}
