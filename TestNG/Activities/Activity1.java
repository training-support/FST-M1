package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	
	WebDriver driver;
    
    // Setup function
    @BeforeClass
    public void setUp() {
        
        driver = new ChromeDriver();
        driver.get("https://training-support.net");
    }
    
    // Test function
    @Test(priority = 1)
    public void homePageTest() {
        Assert.assertEquals(driver.getTitle(), "Training Support");
        
        // Find and click the About page link
        driver.findElement(By.linkText("About Us")).click();
    }
    
    @Test(priority = 2)
    public void aboutPageTest() {
        // Assert page title
        Assert.assertEquals(driver.getTitle(), "About Training Support");
    }
    
  
  @AfterClass
  public void tearDown() {
      // Close the browser
      driver.quit();
  }
  
  
}
