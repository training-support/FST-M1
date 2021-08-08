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

public class CRMActivity9 {
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
        String name, user;
        for (int i=1;i<11;i++)
        {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='list view table-responsive']/tbody")));	
        WebElement colName = driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr[" + i + "]/td[3]"));
        WebElement colUser = driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr[" + i + "]/td[7]"));
        //WebElement webName = row.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr[i]/td[3]"));
           name= colName.getText();
           user=colUser.getText();
           System.out.println("Name: " + name);
           System.out.println("User: " + user);
        }
        }
    
    
    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}

