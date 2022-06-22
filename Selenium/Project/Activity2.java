package com.fst.selnium.project;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Activity2 extends BaseClass{
	@Test
	public void verifyTheHeader() {
		 //Wait for text to load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String actualHeading=driver.findElement(By.className("entry-title")).getText();
		Assert.assertEquals(actualHeading,"Welcome to Alchemy Jobs");
	}
	
	 @AfterClass
	    public void afterClass() {
	        //Close browser
	        driver.close();
	    }
}
