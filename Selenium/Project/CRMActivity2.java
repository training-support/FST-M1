package TestNGFST;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CRMActivity2 {
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
	        String CRMUrl = driver.getCurrentUrl();
	        System.out.println("URL is: " + CRMUrl);
	        //Assert.assertEquals(title, "SuiteCRM");
	    }
	    @AfterTest
	    public void afterMethod() {
	        //Close the browser
	        driver.close();
	    }

	}
