package com.fst.selnium.project;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Activity9 {
	
	String jobPosition;
	static WebDriver driver = new ChromeDriver();
		 
  
	@Test(priority=0)
	public void createJobList() {
		 driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	     driver.manage().window().maximize();
	     
		 WebElement username=driver.findElement(By.id("user_login"));
		 username.sendKeys("root");
		 
		 WebElement password=driver.findElement(By.id("user_pass"));
		 password.sendKeys("pa$$w0rd");
		 
		 WebElement loginButton=driver.findElement(By.id("wp-submit"));
		 loginButton.click();	
	}
	
	@Test(priority=1)
	public void clickJobListing() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> totalMenuItems=driver.findElements(By.cssSelector("#adminmenu>li div:nth-child(3)"));
		for(WebElement listItem:totalMenuItems) {
			String actualMenuName=listItem.getText();
			System.out.println("actualMenuName:"+actualMenuName);
			if(actualMenuName.equalsIgnoreCase("Job Listings 1")) {
				listItem.click();
				break;
			}
			else {
				System.out.println("The Menu item is differnet");
			}
		}
	}
	@Test(priority=2)
	public void fillJobData() {
		WebElement element;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		element=driver.findElement(By.cssSelector("div[id*='toolbar']+div"));
		element.sendKeys("This is FST testing");
		//Application Email/url
		element=driver.findElement(By.name("_application"));
		element.sendKeys("test@Alchemy.com");
		
		//Company WebSite
		element=driver.findElement(By.name("_company_website"));
		element.sendKeys("Alchemy.com");
		
		//Company Twitter
		element=driver.findElement(By.name("_company_twitter"));
		element.sendKeys("test@Alchemy");
		
		//Location
		element=driver.findElement(By.name("_job_location"));
		element.sendKeys("Bangalore");
		
		//Company Name
		element=driver.findElement(By.name("_company_name"));
	    element.sendKeys("FUll Stack Tester");
		jobPosition=element.getText();
		//Company Tagline
	    element=driver.findElement(By.name("_company_tagline"));
	    element.sendKeys("This is Test automation");
	    
	    //Publish button
	    element=driver.findElement(By.cssSelector("button[class*='editor-post-publish']"));
	    element.click();
	    
	    //Click home button
	    element=driver.findElement(By.cssSelector("div[class='edit-post-header'] a"));
	    element.click();
	    
	    //Click job listing option
	    clickJobListing();
	}
	
	@Test(priority=3)
	public void verfiyJobListed() {
		List<WebElement> listedJobs=driver.findElements(By.cssSelector("#the-list>tr>td div span"));
		for(WebElement job:listedJobs) {
			String actulaJobName=job.getText();
			Assert.assertEquals(actulaJobName, jobPosition);
		}
	}
	 @AfterClass
	    public void afterClass() {
	        //Close browser
	        driver.close();
	    }
}
