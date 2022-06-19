package TestNGActivities;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Job_Activity6 {
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
		String titleJobsPage=driver.findElement(By.xpath("//h1[contains(text(),'Jobs')]")).getText();
		System.out.println("Title of the Jobs Page: "+titleJobsPage);
	}
	@Test
	public void Activity6() {
		driver.findElement(By.xpath("//input[@placeholder='Keywords']")).sendKeys("Banking");
		driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='position']"))));
		driver.findElement(By.xpath("//div[@class='position']")).click();
		driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
		WebElement emailId=driver.findElement(By.xpath("//a[@class='job_application_email']"));
		System.out.println("Email id needed: "+emailId.getText());
	}
	@AfterMethod
	public void aftermethod() {
		
		driver.close();
	}
}
