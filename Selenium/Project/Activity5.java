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

public class Activity5 extends BaseClass {

	
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
	public void verifyPageTitle() {
		 //Wait for text to load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String actualPageTitle=driver.getTitle();
		System.out.println(actualPageTitle);
		Assert.assertEquals(actualPageTitle,"Jobs – Alchemy Jobs");
	}
	 @AfterClass
	    public void afterClass() {
	        //Close browser
	        driver.close();
	    }
}
