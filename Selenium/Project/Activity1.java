package com.fst.selnium.project;


import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Activity1 extends BaseClass{
	 
	
	@Test
	public void verifyThePageTitle() {
		 //Wait for text to load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String actualPageTitle=driver.getTitle();
		Assert.assertEquals(actualPageTitle,"Alchemy Jobs – Job Board Application");
	}
	
	 @AfterClass
	    public void afterClass() {
	        //Close browser
	        driver.close();
	    }
}
