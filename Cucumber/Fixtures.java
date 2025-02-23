package stepDefinitions;

import java.time.Duration;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Fixtures extends BaseClass {
	@BeforeAll
	public static void setUp() {
		//Initialize Firefox Driver
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	@AfterAll
	public static void tearDown() {
		//close the browser
		driver.quit();
	}
}