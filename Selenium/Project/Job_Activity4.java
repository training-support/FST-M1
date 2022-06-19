package TestNGActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Job_Activity4 {
	WebDriver driver=new FirefoxDriver();
	@BeforeMethod
	public void beforemethod() {
		
		driver.get("https://alchemy.hguy.co/jobs/");
	}
	@Test
	public void Activity4() {
		String heading2=driver.findElement(By.xpath("//h2")).getText();
		System.out.println("Website Second Heading is: "+heading2);
		Assert.assertEquals(heading2,"Quia quis non");
		driver.close();
	}
}
