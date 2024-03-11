package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	
	WebDriver driver;
	    
	    @BeforeMethod
	    public void beforeMethod() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("https://www.training-support.net");
	    }
	    
	  @Test
	  public void example() {
		
	        String title = driver.getTitle();

	        System.out.println("Page title is: " + title);

	        Assert.assertEquals("Training Support", title);

	        driver.findElement(By.id("about-link")).click();

	        System.out.println("New page title is: " + driver.getTitle());
	        
	        Assert.assertEquals(driver.getTitle(), "About Training Support");
	    }
	 
	    @AfterMethod
	    public void afterMethod() {
	        driver.quit();
	    }
	  
}
