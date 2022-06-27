package CRM_Activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRM_Activity8_TraversingTables1 {
	
WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/crm/");
    }
    
    @Test
    public void TraversingTables() {
	
    	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	driver.findElement(By.cssSelector("#user_name")).sendKeys("admin");
    	driver.findElement(By.cssSelector("#username_password")).sendKeys("pa$$w0rd");
    	driver.findElement(By.cssSelector("#bigbutton")).submit();	        	
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#grouptab_0")));
    	driver.findElement(By.cssSelector("#grouptab_0")).click();
    	driver.findElement(By.cssSelector("#moduleTab_9_Accounts")).click();
    	
    	wait.until(ExpectedConditions.elementToBeClickable(By.className("actionmenulink")));
        List <WebElement> rowElements =  driver.findElements(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr"));
        System.out.println(rowElements.size());
        int rowSize = rowElements.size();
        List <WebElement> colElements =  driver.findElements(By.xpath("//table[contains(@class,'table-responsive')]/thead/tr/th"));
        System.out.println(colElements.size());
        int colSize = rowElements.size();

        for(int i=1; i<=10; i+=2)
        {
            for(int j=1; j<=3;j++)
            {
                System.out.println(driver.findElement(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr["+ i +"]/td["+ j +"]")).getText());
            }
        }
     
}
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
