package TestNGActivities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Job_Activity9 {
WebDriver driver;
	
	@BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        //Open a browser
        driver.get("https://alchemy.hguy.co/jobs/wp-admin"); 

}
	@Test
    public void mainTest() throws InterruptedException {
		
		//Main Test - Create Job listing using backend
		// Login to backend
		WebElement userName = driver.findElement(By.id("user_login"));
	    WebElement password = driver.findElement(By.id("user_pass"));
	       userName.sendKeys("root");
	       password.sendKeys("pa$$w0rd");
	     driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		
		//Locate the left hand menu and click the menu item that says"Job Listings"
	  // Locate the "Add New" button and click 
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     WebElement mainMenu = driver.findElement(By.xpath("//div[contains(text(),'Job Listing')]"));

	     Actions actions = new Actions(driver);              //Instantiating Actions class
	     actions.moveToElement(mainMenu).perform();           //Hovering on main menu
	     System.out.println("Done Mouse hover on Job Listing");
	     WebElement subMenu = driver.findElement(By.linkText("Add New"));          //Locating the element from Add New sunmenu
	     actions.moveToElement(subMenu);                                             //To mouseover on sub menu
	     actions.click().build().perform();                                      ////build()- used to compile all the actions into a single step
	     System.out.println("Selected Add menu");
	     
	     driver.findElement(By.cssSelector(".components-modal__header > button:nth-child(2)")).click();
	     Thread.sleep(3000);
		//Fill in the necessary details
	     WebElement position = driver.findElement(By.cssSelector("#post-title-0"));
	     
	   position.sendKeys("Position for Testing");
	   WebElement compWebsite = driver.findElement(By.id("_company_website"));
	   compWebsite.sendKeys("ibm@ibm.com");
	   
	   // clicking on the first Publish
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("//button[contains(@class, 'publish-panel__toggle')]")).click();
	  
	   Thread.sleep(10000);
	  //clicking on second Publish 
	   driver.findElement(By.xpath("//button[text()='Publish']")).click();
	   
	 //Verify the job listing was created
	   String jobPosted = driver.findElement(By.xpath("//div[contains(@class,'postpublish-header')]//a")).getText();
	     System.out.println("Job Posted is : " + jobPosted);
	     Assert.assertEquals("Position for Testing", jobPosted);		
	}
	
	@AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
	
}
