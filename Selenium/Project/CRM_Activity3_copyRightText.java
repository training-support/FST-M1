package CRM_Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity3_copyRightText {
	
	WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/crm/");
    }
	
	
	 @Test
	    public void copyrighttext() {
	     
     	String copyrighttext = driver.findElement(By.linkText("© Supercharged by SuiteCRM")).getText();
   	
     	   System.out.println("copyrighttext Text is: " + copyrighttext);
 }
	 
	 @AfterMethod
	    public void afterMethod() {
	        //Close the browser
	        driver.quit();
	    }

}
