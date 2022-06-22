package Cucumber_Practise.Features.StepDefinisitons;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	
	static WebDriver driver=new ChromeDriver();
	
	static WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

}
