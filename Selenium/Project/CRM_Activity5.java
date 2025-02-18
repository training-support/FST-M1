package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CRM_Activity5 {
	WebDriver driver;
	WebDriverWait wait;
    
    @BeforeClass
    public void setUp() {
        //Open a browser
        driver = new ChromeDriver();
     driver.get("http://alchemy.hguy.co/crm");
    }
    
    @Test(priority = 1)
	  public void loginFormTest() {
		  //Provide username and password
		  driver.findElement(By.id("user_name")).sendKeys("admin");
		  driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		  //Find the submit button and click it
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
		  
  }
    
    // Test function
    @Test(priority = 2)
    public void colorNavMenu() throws InterruptedException {
    	Thread.sleep(5000);
    	//Get the color of navigation menu
    	driver.manage().window().maximize();
    	Color navMenuColor = Color.fromString(driver.findElement(By.xpath("//div[@id='toolbar']")).getCssValue("color"));
    	 System.out.println("Color as RGB: " + navMenuColor.asRgb());
         System.out.println("Color as hexcode: " + navMenuColor.asHex());
    	
    }
    
    
	 @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	    
}
