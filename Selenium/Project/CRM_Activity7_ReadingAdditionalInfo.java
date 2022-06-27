package CRM_Activities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CRM_Activity7_ReadingAdditionalInfo {
	
WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/crm/");
    }
    
    
    @Test
    public void ReadingAdditionalInfo() {
	
    	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	driver.findElement(By.cssSelector("#user_name")).sendKeys("admin");
    	driver.findElement(By.cssSelector("#username_password")).sendKeys("pa$$w0rd");
    	driver.findElement(By.cssSelector("#bigbutton")).submit();	        	
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#grouptab_0")));
    	driver.findElement(By.cssSelector("#grouptab_0")).click();
    	driver.findElement(By.cssSelector("#moduleTab_9_Leads")).click();
    	

     
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[10]/span[1]/span[1]")));
        driver.findElement(By.xpath("//tbody/tr[1]/td[10]/span[1]/span[1]")).click();
        //WebElement frame1 = driver.findElement(By.id("ajaxUI-history-iframe"));
        //driver.switchTo().frame(frame1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='phone']")));
        WebElement phone = driver.findElement(By.xpath("//span[@class='phone']"));
        System.out.println("The number is: " + phone.getText());
      
}
    
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
