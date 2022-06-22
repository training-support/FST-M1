package com.fst.selnium.project;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Activity3 extends BaseClass{

	
	
	@Test
	public void verifyThePageUrl() {
		 //Wait for text to load
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String actualPageUrl=driver.getCurrentUrl();
		System.out.println("The page url is :"+actualPageUrl);
		Assert.assertEquals(actualPageUrl,"https://alchemy.hguy.co/jobs/");
	}
	
	 @AfterClass
	    public void afterClass() {
	        //Close browser
	        driver.close();
	    }
}
