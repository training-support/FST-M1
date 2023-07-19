package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity6 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);

		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 5);
		driver.get("https://www.training-support.net/selenium");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(
				MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).flingToEnd(5)"));
		driver.findElementByXPath("//android.view.View[contains(@text,'Popups')]").click();

	}

	@Test(priority = 1)
	public void LoginSuccess() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.view.View[4]").click();
		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'username']").sendKeys("admin");
		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'password']").sendKeys("password");
		driver.findElementByXPath("//android.widget.Button[@text = 'Log in']").click();
		String msg = driver.findElementByXPath("//android.view.View[@resource-id = 'action-confirmation']").getText();
		System.out.println(msg);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(msg, "Welcome Back, admin");

	}

	@Test(priority = 2)
	public void LoginFailedTest() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.view.View[5]").click();
		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'username']").clear();
		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'username']").sendKeys("admin2");
		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'password']").clear();
		driver.findElementByXPath("//android.widget.EditText[@resource-id = 'password']").sendKeys("password2");
		driver.findElementByXPath("//android.widget.Button[@text = 'Log in']").click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@resource-id = 'action-confirmation']")));
		String msg = driver.findElementByXPath("//android.view.View[@resource-id = 'action-confirmation']").getText();
		System.out.println(msg);
		Assert.assertEquals(msg, "Invalid Credentials");

	}

	@AfterTest
	public void afterClass() {
		driver.quit();
	}
}
