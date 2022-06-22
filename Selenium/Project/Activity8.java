package com.fst.selnium.project;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import junit.framework.Assert;

public class Activity8 {
	 static WebDriver driver;
	 
	 @BeforeClass
	    public static void beforeClass() {
	         driver = new ChromeDriver();
	 
	        //Open browser
	        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	        driver.manage().window().maximize();
	    }
	 
	 @Test
	 public static void userLogin() {
		 
		 WebElement username=driver.findElement(By.id("user_login"));
		 username.sendKeys("root");
		 
		 WebElement password=driver.findElement(By.id("user_pass"));
		 password.sendKeys("pa$$w0rd");
		 
		 WebElement loginButton=driver.findElement(By.id("wp-submit"));
		 loginButton.click();
		 
		 String actualPageTitle=driver.getTitle();
		 System.out.println("The actual title is :"+actualPageTitle);
		 Assert.assertEquals(actualPageTitle, "Dashboard ‹ Alchemy Jobs — WordPress");
	 }
	 
	 @AfterClass
	    public void afterClass() {
	        //Close browser
	        driver.close();
	    }
}
