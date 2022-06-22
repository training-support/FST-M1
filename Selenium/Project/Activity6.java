package com.fst.selnium.project;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Activity6 extends BaseClass{
	
	
	@Test
	public void clickOnJobs() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#primary-menu li")));
		 //Wait for text to load
		//Thread.sleep(4000);
		List<WebElement> navigationMenuItems=driver.findElements(By.cssSelector("#primary-menu li"));
		for(WebElement element:navigationMenuItems) {
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			String actualNavigationItem=element.getText();
			if(actualNavigationItem.equalsIgnoreCase("Jobs")) {
			element.click();
			break;
			}
			else {
				System.out.println("The Actual navigation menu item name is different, Please check it.");
			}
		}
	}
	@Test(priority=0)
	public void searchForJob() {
		 //Wait for text to load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("search_keywords")).sendKeys("Banking");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> jobList=driver.findElements(By.cssSelector("ul[class='job_listings'] li"));
		int size=jobList.size();
		if(size!=0) {
			driver.findElement(By.cssSelector("ul[class='job_listings'] li:nth-child(1) a")).click();
			driver.findElement(By.cssSelector("input[type='button']")).click();
			String actualEmail=driver.findElement(By.className("job_application_email")).getText();
			System.out.println("To apply for this job email your details to :"+actualEmail);
		}else {
			Assert.fail("There are no jobs listed out. Search for other job.");
		}
	}
	
	 @AfterClass
	    public void afterClass() {
	        //Close browser
	        driver.close();
	    }
}
