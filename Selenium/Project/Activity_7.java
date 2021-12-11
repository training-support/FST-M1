package com.ibm.JobBoard;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_7 {
	WebDriver driver;
	
	@BeforeMethod
	public void browserSetUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();   
		driver.get("https://alchemy.hguy.co/jobs/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void applyJob()
	{
		WebElement jobListing = driver.findElement(By.xpath("//a[text()='Post a Job']"));
		jobListing.click();
		if(driver.getTitle().contains("Post a Job"))
		{
			System.out.println("Navigated successfully to Post a Job page");
		}
		else
		{
			System.out.println("Could not Navigate successfully to Post a Job page");
		}
		driver.findElement(By.xpath("//input[@id='create_account_email']")).sendKeys("swathi2@ibm.com");
		driver.findElement(By.xpath("//input[@id='job_title']")).sendKeys("Automation Tester");
		driver.findElement(By.xpath("//input[@id='job_location']")).sendKeys("Bangalore");
		Select jobType = new Select(driver.findElement(By.xpath("//select[@id='job_type']")));
		jobType.selectByVisibleText("Full Time");
		driver.findElement(By.xpath("//input[@name='application']")).sendKeys("https://alchemy.hguy.co/jobs/post-a-job/");
		driver.switchTo().frame("job_description_ifr");
		WebElement jobName = driver.findElement(By.xpath("//body[@id='tinymce']"));
		jobName.sendKeys("QA Job");
		String job = jobName.getText();
		driver.switchTo().parentFrame();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(By.id("company_name")).sendKeys("IBM Bangalore");
		driver.findElement(By.id("company_website")).sendKeys("www.ibm.com");
		driver.findElement(By.name("submit_job")).click();
		driver.findElement(By.id("job_preview_submit_button")).click();
		WebElement jobs = driver.findElement(By.xpath("//a[text()='Jobs']"));
		jobs.click();
		driver.findElement(By.xpath("//input[@id='search_keywords']")).sendKeys("QA Job");
		driver.findElement(By.xpath("//div[@class='search_submit']/input")).click();
		List<WebElement> joblisting = driver.findElements(By.xpath("//div[@class='position']"));
		for(WebElement joblisted:joblisting)
		{
			if(joblisted.getText().contains(job))
			{
				System.out.println("Job "+job+" is listed");
			}
		}
		driver.close();
		
	}

}
