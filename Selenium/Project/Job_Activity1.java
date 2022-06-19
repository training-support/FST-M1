package TestNGActivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Job_Activity1 {
	WebDriver driver=new FirefoxDriver();

	@BeforeMethod
	public void beforeclass() {
		
		driver.get("https://alchemy.hguy.co/jobs/");
	}
	
	@Test
	public void Activity1() {
		String title= driver.getTitle();
		System.out.println("Title of the website: "+title);
		Assert.assertEquals(title, "Alchemy Jobs – Job Board Application");
		driver.close();
	}
}
