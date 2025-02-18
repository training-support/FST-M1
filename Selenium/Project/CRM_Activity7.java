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

public class CRM_Activity7 {
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
    
    @Test(priority = 2)
	public void additionalInformation() throws InterruptedException {
		driver.manage().window().maximize();
//		Navigate to Sales -> Leads
		driver.findElement(By.id("grouptab_0")).click();
		driver.findElement(By.id("moduleTab_9_Leads")).click();
		Thread.sleep(2000);
//		In the table, find the Additional information icon at the end of the row of the lead information. Click it.
		driver.findElement(By.xpath("//span[@title='Additional Details']")).click();
		Thread.sleep(2000);
//		Read the popup and print the phone number displayed in it.
		WebElement additionalDetails = driver.findElement(By.xpath("//span[@class='phone']"));
		String mobileNumber = additionalDetails.getText();
		System.out.println("The mobile number is :" + mobileNumber);
		Assert.assertFalse(mobileNumber.isEmpty(),"Mobile Number not available");

	}

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    
}
