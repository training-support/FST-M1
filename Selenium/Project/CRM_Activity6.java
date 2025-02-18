package Project;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CRM_Activity6 {
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
    
    
    //Ensure that the “Activities” menu item exists
    
    @Test(priority = 2)
    public void locateMenu() throws InterruptedException {
    	Thread.sleep(5000);
    	driver.manage().window().maximize();
    	
    	WebElement activitiesMenu = driver.findElement(By.id("grouptab_3"));
    	String textAct = activitiesMenu.getText();
    	Thread.sleep(5000);
    	System.out.println("The Menu has " +  textAct);
    	Assert.assertTrue(activitiesMenu.isEnabled());
    	
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    
}
