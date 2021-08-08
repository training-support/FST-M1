package TestNGFST;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CRMActivity3 {
		    WebDriver driver;
	    
	    @BeforeTest
	    public void beforeMethod() {
	        //Create a new instance of the Firefox driver
	        driver = new FirefoxDriver();
	            
	        //Open the browser
	        driver.get("http://alchemy.hguy.co/crm");
	    }
	    
	    @Test
	    public void testCase1() {
	        //This test case will pass
	        String footer = driver.findElement(By.id("admin_options")).getText();
	        System.out.println("Footer Text is: " + footer);
	        //Assert.assertEquals(title, "SuiteCRM");
	    }
	    @AfterTest
	    public void afterMethod() {
	        //Close the browser
	        driver.close();
	    }

	}
