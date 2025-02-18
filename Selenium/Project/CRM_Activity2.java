package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CRM_Activity2 {
	
	WebDriver driver;
	WebDriverWait wait;
    
    @BeforeClass
    public void setUp() {
        //Open a browser
        driver = new ChromeDriver();

       
        driver.get("http://alchemy.hguy.co/crm");
    }
    
    
    // Test function
    @Test(priority = 1)
    public void headerImageURL() {
    	
        //Get the URL of the header image
    	WebElement headerImage = driver.findElement(By.xpath("//div/img"));
      //Print the URL to the console
    	String actualUrl =headerImage.getDomAttribute("src");
    	
    	System.out.println("The URL of image is " + actualUrl);
    	
    	String expectedUrl = "themes/default/images/company_logo.png?v=cK7kLsY0ftg72ZVHTYUT_g";
    	Assert.assertEquals(actualUrl, expectedUrl);
    	
    }
  
  @AfterClass
  public void tearDown() {
      driver.quit();
  }
  
  
}
