package com.fst.selnium.project;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity7 extends BaseClass{
	String jobTitle;
	
	@Test
	public void clickOnPostAJob() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#primary-menu li")));
		 //Wait for text to load
		
		List<WebElement> navigationMenuItems=driver.findElements(By.cssSelector("#primary-menu li"));
		for(WebElement element:navigationMenuItems) {
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			String actualNavigationItem=element.getText();
			if(actualNavigationItem.equalsIgnoreCase("Post a Job")) {
			element.click();
			break;
			}
		}
	}
	@Test(priority=0)
	public void fillCompanyDetiails() throws InterruptedException {
		
		WebElement element;
		
		//Your email:
		element=driver.findElement(By.id("create_account_email"));
		element.sendKeys("AutoTest1234@alchemy.com");
		//job title
		element=driver.findElement(By.id("job_title"));
		element.sendKeys("FTS Testing");
		jobTitle="FTS Testing";
		System.out.println("jobTitle:"+jobTitle);
		//job  description
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id='job_description_ifr']")));
		element=driver.findElement(By.id("tinymce"));
		element.sendKeys("This is FST learning job creation.");
		driver.switchTo().defaultContent();
		//Application url
		element=driver.findElement(By.id("application"));
		element.sendKeys("https://alchemy.hguy.co/jobs");
		//Company Name
		element=driver.findElement(By.id("company_name"));
		element.sendKeys("Alchemy");
		
		//WebSite
		element=driver.findElement(By.id("company_website"));
		element.sendKeys("https://alchemy.hguy.co/jobs");
		
		//Tagline
		element=driver.findElement(By.id("company_tagline"));
		element.sendKeys("Job Board Application");
	
		
		//Twitter username
		element=driver.findElement(By.id("company_twitter"));
		element.sendKeys("@Alchemy");
		
		//Logo
		element=driver.findElement(By.xpath("//input[@type='file']"));
		element.sendKeys("C:\\Users\\SKARANA\\Desktop\\Alchemy.PNG");
		
		//Click Preview button
		element=driver.findElement(By.name("submit_job"));
		element.click();
		
		//Submit listing
		element=driver.findElement(By.id("job_preview_submit_button"));
		element.click();

		
	}
	@Test(priority=1)
	public void clickOnJobs() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#primary-menu li")));

		List<WebElement> navigationMenuItems = driver.findElements(By.cssSelector("#primary-menu li"));
		for (WebElement element : navigationMenuItems) {
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			String actualNavigationItem = element.getText();
			if (actualNavigationItem.equalsIgnoreCase("Jobs")) {
				element.click();

				WebElement searchKeyword = driver.findElement(By.id("search_keywords"));
				System.out.println("Job title to be searched:" + jobTitle);
				searchKeyword.sendKeys(jobTitle);
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				WebElement searchJobBtn = driver.findElement(By.cssSelector("input[value='Search Jobs']"));
				searchJobBtn.click();
				List<WebElement> jobList = driver.findElements(By.cssSelector("ul[class='job_listings'] li"));
				int size = jobList.size();
				if (size != 0) {
					String actualJobTitle = driver
							.findElement(By.cssSelector("ul[class='job_listings'] li:nth-child(1) a div h3")).getText();
					Assert.assertEquals(actualJobTitle, jobTitle);
					break;
				} else {
					Assert.fail("There are no jobs listed out. Search for other job.");
				}
			}

		}
	}
	 @AfterClass
	    public void afterClass() {
	        //Close browser
	        driver.close();
	    }
}
