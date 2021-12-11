package com.ibm.JobBoard;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_1 {
	
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
	public void verifyWebsiteTitle()
	{
		String websiteTitle = driver.getTitle();
		System.out.println("Website Title is: "+websiteTitle);
		if(websiteTitle.equals("Alchemy Jobs – Job Board Application"))
		{
			driver.close();
		}
		
	}

}
