package TestNGFST;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CRMActivity5 {
		    WebDriver driver;
		    
	    
	    @BeforeTest
	    public void beforeMethod() {
	        //Create a new instance of the Firefox driver
	        driver = new FirefoxDriver();
	            
	        //Open the browser
	        driver.get("http://alchemy.hguy.co/crm");
	    }
	    
	    @Test
	    public void testCase1() throws InterruptedException {
	        //This test case will pass
	       	WebElement username = driver.findElement(By.id("user_name"));
	        WebElement password = driver.findElement(By.id("username_password"));
	        username.sendKeys("admin");
	        password.sendKeys("pa$$w0rd");
	        driver.findElement(By.id("bigbutton")).click();
	        String Toolbarcolor = driver.findElement(By.id("toolbar")).getCssValue("color");
	        Thread.sleep(10);
	        
	        System.out.println("Color is: " + Toolbarcolor);
	        //Assert.assertEquals(title, "SuiteCRM");
	    }
	   

		@AfterTest
	    public void afterMethod() {
	        //Close the browser
	        driver.close();
	    }

	}

