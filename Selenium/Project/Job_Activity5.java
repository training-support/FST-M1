package TestNGActivities;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Job_Activity5 {
	WebDriver driver=new FirefoxDriver();
	@BeforeMethod
	public void beforemethod() throws InterruptedException {
		
		driver.get("https://alchemy.hguy.co/jobs/");
		List<WebElement> list1 = driver.findElements(By.xpath("//ul[@id='primary-menu']/li"));
		for(WebElement cellValue : list1) {         
			System.out.println("Cell Value: " + cellValue.getText());
            if(cellValue.getText().contains("Jobs"))
            {           	
            	cellValue.click();
            	Thread.sleep(3000);
            	break;
            }          
        }		
	}
	@Test
	public void Activity5() {
		String titleJobsPage=driver.findElement(By.xpath("//h1[contains(text(),'Jobs')]")).getText();
		System.out.println("Title of the Jobs Page: "+titleJobsPage);
		Assert.assertEquals(titleJobsPage, "Jobs");
	}
	@AfterMethod
	public void aftermethod() {
		driver.close();
	}
}
