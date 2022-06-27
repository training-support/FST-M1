package CRM_Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Test
public class CRM_Activity2_headerUrl {
	
WebDriver driver;
	    
	    @BeforeMethod
	    public void beforeMethod() {
	        //Create a new instance of the Firefox driver
	        driver = new FirefoxDriver();
	        
	        //Open browser
	        driver.get("https://alchemy.hguy.co/crm/");
	    }

	    @Test
	    public void CRM_headerUrl_Activity2() {
	    	
    	String headerurl = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/form[1]/div[1]/img[1]")).getAttribute("src");
  	
    	   System.out.println("Header Image url is: " + headerurl);
}

	@AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
	
}
