package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CRM_Activity3 {

	WebDriver driver;
	WebDriverWait wait;
    
    @BeforeClass
    public void setUp() {
        //Open a browser
        driver = new ChromeDriver();       
        driver.get("http://alchemy.hguy.co/crm");
    }
  
    @Test(priority = 1)
    public void copyrightText() {
    	
    	String textCR = driver.findElement(By.id("admin_options")).getText();
    	System.out.println("The first copyright text is : " + textCR);
    }
    
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
