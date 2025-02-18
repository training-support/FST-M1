package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CRM_Activity4 {

	WebDriver driver;
	WebDriverWait wait;
    
    @BeforeClass
    public void setUp() {
        //Open a browser
        driver = new ChromeDriver();       
        driver.get("http://alchemy.hguy.co/crm");
    }
    
    @Test(priority = 1)
	  public void homepageLogin() throws InterruptedException {
		  //Provide username and password
		  driver.findElement(By.id("user_name")).sendKeys("admin");
		  driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		  //Find the submit button and click it
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
		  Thread.sleep(5000);
		  String homePage = driver.findElement(By.id("tab0")).getText();
		  Assert.assertEquals(homePage, "SUITECRM DASHBOARD");
		  
  }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
