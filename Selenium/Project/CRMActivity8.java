package TestNGFST;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CRMActivity8 {
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
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("moduleTab_9_Accounts")));
	        driver.findElement(By.id("moduleTab_9_Accounts")).click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='list view table-responsive']/tbody")));
	        //Get columns
	        List<WebElement> cols = driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr[1]/td"));
	        //Get rows
	       // WebElement rows = driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody"));
	        //List <WebElement> rows1= rows.findElements(By.tagName("tr"));
	        List <WebElement> rows = driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));
	        System.out.println("Total Rows:" + rows.size());
	        System.out.println("Total Cols:" + cols.size());
	        //System.out.println(cols);
	        for(int i=1; i<=10; i++) {
	            WebElement row = driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr[" + i + "]"));
	            System.out.println("Row " + i + ": " + row.getText());
	            i++;
	        }
	        //int rowCount = driver.findElements(By.xpath("//tr[@class='oddListRowS1']")).size();
	        //System.out.println(rowCount);
	        
	    }
	    
	    @AfterTest
	    public void afterMethod() {
	        //Close the browser
	        driver.close();
	    }
}