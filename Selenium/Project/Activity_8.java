package com.ibm.JobBoard;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_8 {
	WebDriver driver;
	WebDriverWait wait;
	
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
	public void webSiteBackend() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='user_login']")).clear();
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
		driver.findElement(By.xpath("//input[@id='user_pass']")).clear();
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("​​pa$$w0rd");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='wp-submit']")).sendKeys(Keys.ENTER);
		
		if(driver.findElement(By.xpath("//div[@class='wrap']/h1")).getText().contains("Dashboard"))
		{
			System.out.println("Logged in successfully");
		}
		else
		{
			System.out.println("Login failed");
		}
		driver.close();
	}
	

}
