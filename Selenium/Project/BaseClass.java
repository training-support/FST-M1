package com.fst.selnium.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	 WebDriver driver;
	 
	 @BeforeClass
	    public void beforeClass() {
	         driver = new ChromeDriver();
	 
	        //Open browser
	        driver.get("https://alchemy.hguy.co/jobs/");
	        driver.manage().window().maximize();
	    }
}
