package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofMillis;
import static activities.ActionBase.doSwipe;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class Activity6 {
    WebDriverWait wait;
    AndroidDriver driver;
    String message;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get("https://v1.training-support.net/selenium");
    }

    @Test(priority = 1)
    public void testcase1() throws InterruptedException {
        Dimension dims=driver.manage().window().getSize();
        Point start=new Point((int)(dims.getWidth()*0.5),(int)(dims.getHeight()*0.8));
        Point end= new Point((int)(dims.getWidth()*0.3),(int)(dims.getHeight()*0.1));
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
        doSwipe(driver,start,end,1916);
        doSwipe(driver,start,end,1916);
        doSwipe(driver,start,end,1916);
        doSwipe(driver,start,end,1916);
        doSwipe(driver,start,end,1916);
        boolean b=driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Training Support - Selenium']/android.view.View[2]/android.view.View[3]/android.view.View[19]")).isDisplayed();
        if(b==true){
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.webkit.WebView[@text='Training Support - Selenium']/android.view.View[2]/android.view.View[3]/android.view.View[19]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Sign In ']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']"))).sendKeys("admin");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']"))).sendKeys("password");
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Log in']"))).click();
            message=driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='action-confirmation']")).getText();
            System.out.println(message);
            Assert.assertEquals(message,"Welcome Back, admin");

        }

    }

    @Test(priority = 2)
    public void testcase2() throws InterruptedException, MalformedURLException {
        setup();
        Dimension dims=driver.manage().window().getSize();
        Point start=new Point((int)(dims.getWidth()*0.5),(int)(dims.getHeight()*0.8));
        Point end= new Point((int)(dims.getWidth()*0.3),(int)(dims.getHeight()*0.1));
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
        doSwipe(driver,start,end,1916);
        doSwipe(driver,start,end,1916);
        doSwipe(driver,start,end,1916);
        doSwipe(driver,start,end,1916);
        doSwipe(driver,start,end,1916);
        boolean b=driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Training Support - Selenium']/android.view.View[2]/android.view.View[3]/android.view.View[19]")).isDisplayed();
        if(b==true){
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.webkit.WebView[@text='Training Support - Selenium']/android.view.View[2]/android.view.View[3]/android.view.View[19]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Sign In ']"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='username']"))).sendKeys("admin");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='password']"))).sendKeys("passwo");
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Log in']"))).click();
            message=driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='action-confirmation']")).getText();
            System.out.println(message);
            Assert.assertEquals(message,"Invalid Credentials");

        }

    }

    @AfterTest
    public void close(){
        driver.quit();
    }
}
