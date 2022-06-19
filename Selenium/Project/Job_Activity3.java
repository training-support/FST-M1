package TestNGActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Job_Activity3 {

	WebDriver driver=new FirefoxDriver();
	@BeforeMethod
	public void beforemethod() {
		
		driver.get("https://alchemy.hguy.co/jobs/");
	}
	@Test
	public void Activity2() {
		String imgUrl=driver.findElement(By.xpath("//img[@itemprop='image']")).getAttribute("src");
		System.out.println("Image Url is- "+imgUrl);
	}
	@AfterMethod
	public void aftermethod() {
		driver.close();
	}
}
