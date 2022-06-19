package TestNGActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Job_Activity2 {
	WebDriver driver=new FirefoxDriver();
	@BeforeMethod
	public void beforemethod() {
		
		driver.get("https://alchemy.hguy.co/jobs/");
	}
	@Test
	public void Activity2() {
		String heading=driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
		System.out.println("Website Heading is: "+heading);
		//Assert.assertEquals(heading,"Welcome to Alchemy Jobs");
		Assert.assertTrue(heading.contentEquals("Welcome to Alchemy Jobs"));
		driver.close();
	}
}
