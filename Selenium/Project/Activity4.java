package com.fst.selnium.project;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Activity4 extends BaseClass{

	@Test
	public void verifyTheSecondHeader() {
		 //Wait for text to load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String actualSecondHeading=driver.findElement(By.cssSelector("div[class='entry-content clear']>h2")).getText();
		Assert.assertEquals(actualSecondHeading,"Quia quis non");
	}
	
	 @AfterClass
	    public void afterClass() {
	        //Close browser
	        driver.close();
	    }
}
