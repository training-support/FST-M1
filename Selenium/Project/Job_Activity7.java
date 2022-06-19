package TestNGActivities;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Job_Activity7 {
WebDriver driver;
	
	@BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        //Open a browser
        driver.get("https://alchemy.hguy.co/jobs");  
}
	@DataProvider(name = "Form_Data")
    public static Object[][] credentials() {
        return new Object[][] { { "MeenaD11@in.ibm.com", "Test Manager", "MD@ibm.com", "IBM India" }};
	}

	@Test (dataProvider = "Form_Data")
    public void mainTest(String email, String JobTitle, String WebID, String CompanyName) throws InterruptedException {
		
		//Main Test - Post a  JOB
		
		//Navigate to Post a JOB screen
		driver.findElement(By.xpath("//li[@id='menu-item-26']")).click();
		
		// Enter the details and click on Preview
		WebElement emailId = driver.findElement(By.id("create_account_email"));
	    emailId.sendKeys(email);
	    WebElement jobtitle = driver.findElement(By.id("job_title"));
	    jobtitle.sendKeys(JobTitle);
	    Select drpjobtype = new Select(driver.findElement(By.id("job_type")));
	    drpjobtype.selectByVisibleText("Internship");
	    
	    driver.switchTo().frame("job_description_ifr");// switch to the Description frame
	    WebElement iframe = driver.switchTo().activeElement();
	    iframe.sendKeys("job Description for a Tester");
	    
	    driver.switchTo().defaultContent();
	    WebElement webId = driver.findElement(By.id("application"));
	    webId.sendKeys(WebID);
	    WebElement companyName = driver.findElement(By.id("company_name"));
	    companyName.sendKeys(CompanyName);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@name='submit_job']")).click();
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    Thread.sleep(3000);
	    driver.findElement(By.id("job_preview_submit_button")).click();
	    
	    //verify the job is posted by visiting the Jobs page
	     //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    Thread.sleep(3000);
	     driver.findElement(By.xpath("//li[@id='menu-item-24']")).click();
	     WebElement search = driver.findElement(By.id("search_keywords"));
	     search.sendKeys(JobTitle);
	     driver.findElement(By.className("search_submit")).click();
	     Thread.sleep(3000);
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  
	//identify job posted in the list    
	     String position = driver.findElement(By.xpath("//div[@class='position']")).getText();
	     //System.out.println("The Job Positon posted is : " + position);
	     if (position.contentEquals("Test Manager"))
	        {
	        	System.out.println("The Job Position posted is " + position);
	        }
	        else
	        { 
	        	System.out.println("The Job Position posted is Not Test Manager ");
	        	
	        }
	     //Assert.assertEquals("Test Manager", position);	
	    
    }
	
	@AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
	
}

