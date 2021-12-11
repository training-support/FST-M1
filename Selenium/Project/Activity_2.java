package com.ibm.JobBoard;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_2 {
	
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
	public void verifyHeaderTitle()
	{
		WebElement heading = driver.findElement(By.xpath("//h1[@class='entry-title']"));
		String pageHeader = heading.getText();
		System.out.println("Header is: "+pageHeader);
		if(pageHeader.equals("Welcome to Alchemy Jobs"))
		{
			driver.close();
		}
		
	}

}
