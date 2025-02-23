package LiveProject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1Login {
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		// Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Open Selenium page
		driver.get("https://v1.training-support.net/selenium");
	}

	@Test(priority = 1)
	public void loginTestwithCorrectCreds() throws InterruptedException {
		// Wait for page to load
		wait.until(
				ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='Selenium']")));
		// driver.manage().window().getSize();
		// UiScrollable object string
		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

		// Scroll to required element
		Thread.sleep(5000);
		driver.findElement(AppiumBy.androidUIAutomator(UiScrollable
				+ ".scrollForward(2).getChildByText(className(\"android.widget.TextView\"), \"Login Form\")"));

		// Wait for page to load
		wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='Login Form']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath(
				"//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")))
				.sendKeys("admin");
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath(
				"//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")))
				.sendKeys("password");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();

		// Assertions
		String LoginMsg = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Welcome Back, admin\"]"))
				.getText();
		Assert.assertTrue(LoginMsg.contains("Welcome Back"));
	}

	@Test(priority = 2)
	public void loginTestwithWrongCreds() throws InterruptedException {
		// Wait for page to load
		wait.until(
				ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='Selenium']")));
		// UiScrollable object string
		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

		// Scroll to required element
		Thread.sleep(5000);
		driver.findElement(AppiumBy.androidUIAutomator(UiScrollable
				+ ".scrollForward(4).getChildByText(className(\"android.widget.TextView\"), \"Login Form\")"));

		// Wait for page to load
		wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='Login Form']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath(
				"//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")))
				.sendKeys("admin");
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath(
				"//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")))
				.sendKeys("password");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();

		// Assertions
		String LoginMsg = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Invalid Credentials\"]"))
				.getText();
		Assert.assertTrue(LoginMsg.contains("Invalid"));
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}