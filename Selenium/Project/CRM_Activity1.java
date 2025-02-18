package Project;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CRM_Activity1 {
	
	WebDriver driver;
    
    @BeforeClass
    public void setUp() {
        
        driver = new ChromeDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }
    
    // Test function
    @Test(priority = 1)
    public void homePageTest() {
    	
        Assert.assertEquals(driver.getTitle(), "SuiteCRM");
      
    }
  
  @AfterClass
  public void tearDown() {
      driver.quit();
  }
  
  
}
