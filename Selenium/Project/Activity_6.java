package com.ibm.JobBoard;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_6 {
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
		WebElement jobs = driver.findElement(By.xpath("//a[text()='Jobs']"));
		jobs.click();
		if(driver.getTitle().contains("Jobs"))
		{
			System.out.println("Navigated successfully to Jobs page");
		}
		else
		{
			System.out.println("Could not Navigate successfully to Jobs page");
		}
		driver.findElement(By.xpath("//input[@id='search_keywords']")).sendKeys("Banking");
		driver.findElement(By.xpath("//div[@class='search_submit']/input")).click();
		driver.findElement(By.xpath("//h3[contains(text(),'Banking clerk')]")).click();
		driver.findElement(By.xpath("//input[@class='application_button button']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement mail = driver.findElement(By.xpath("//div[@class='application_details']/p/a"));
		String mailId = mail.getAttribute("innerHTML");
		System.out.println("Mail address is: " +mailId);
		driver.close();
		
	}


}
