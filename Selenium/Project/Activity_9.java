package com.ibm.JobBoard;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_9 {
	WebDriver driver;
	
	@BeforeMethod
	public void browserSetUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();   
		driver.get("https://alchemy.hguy.co/jobs/wp-admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void jobListBackEnd() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("​​pa$$w0rd");
		driver.findElement(By.xpath("//input[@id='wp-submit']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Job Listings']")).click();
		driver.findElement(By.xpath("//a[@class='page-title-action']")).click();
		driver.findElement(By.xpath("//input[@name='_job_location']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@id='_company_name']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@id='_company_website']")).sendKeys("ibm.com");
		driver.findElement(By.xpath("//input[@id='_company_tagline']")).sendKeys("Great place");
		driver.findElement(By.xpath("//input[@id='_company_twitter']")).sendKeys("IBM@twitter");
		driver.findElement(By.xpath("//input[@id='_job_expires']")).sendKeys("20/12/2021");
		driver.findElement(By.xpath("//input[@id='_filled']")).click();
		driver.findElement(By.xpath("//input[@id='_featured']")).click();
		driver.findElement(By.xpath("//a[@class='components-button editor-post-preview is-secondary']")).click();
		driver.close();
	}
	

}
