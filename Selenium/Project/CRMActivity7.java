package TestNGFST;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CRMActivity7 {
		    WebDriver driver;
		    
	    
	    @BeforeTest
	    public void beforeMethod() {
	        //Create a new instance of the Firefox driver
	        driver = new FirefoxDriver();
	            
	        //Open the browser
	        driver.get("http://alchemy.hguy.co/crm");
	    }
	    
	    @Test
	    public void testCase1() throws InterruptedException {
	    	WebDriverWait wait=new WebDriverWait(driver,5);
	        //This test case will pass
	       	WebElement username = driver.findElement(By.id("user_name"));
	        WebElement password = driver.findElement(By.id("username_password"));
	        username.sendKeys("admin");
	        password.sendKeys("pa$$w0rd");
	        driver.findElement(By.id("bigbutton")).click();
	        Thread.sleep(20);
	        driver.findElement(By.id("grouptab_0")).click();
	        driver.findElement(By.id("moduleTab_9_Leads")).click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='oddListRowS1'][1]/td[10]/span/span[@title='Additional Details']")));
	        //Thread.sleep(40);      
	        driver.findElement(By.xpath("//tr[@class='oddListRowS1'][1]/td[10]/span/span[@title='Additional Details']")).click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id ='ui-id-23']//span[@class = 'phone']")));
	        String phone= driver.findElement(By.xpath("//div[@id ='ui-id-23']//span[@class = 'phone']")).getText();
	        System.out.println(phone);
	        
	    }
	   
		@AfterTest
	    public void afterMethod() {
	        //Close the browser
	        driver.close();
	    }

	}

