package CRM_Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity8 {
    public static void main(String[] args)
    {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //login into site
        driver.get("http://alchemy.hguy.co/crm");
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

        //getting into sales tab and then accounts tab
        driver.findElement(By.id("grouptab_0")).click();
        driver.findElement(By.id("moduleTab_9_Accounts")).click();

        //waiting till element is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@id = 'pagination']")));

//getting no. of rows
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println("no. of rows" +rows.size());


//getting no. of columns
        List<WebElement> column = driver.findElements(By.xpath("//table/thead/tr/th"));
        System.out.println("no. of columns :"+column.size());


//getting the table element
        WebElement tbl = driver.findElement(By.xpath("//table[@class='list view table-responsive']"));


//getting the size odd rows from the table
        List<WebElement> oddRows = tbl.findElements(By.xpath("//table/tbody/tr[@class='oddListRowS1']"));
        System.out.println("no. of odd rows :"+oddRows.size());

//getting the value of 3rd column for all the ODD rows
        List<WebElement> RowCol = tbl.findElements(By.xpath("//table/tbody/tr[@class='oddListRowS1']/td[3]"));

//Printing first 5 names of odd rows
        for(int q=0; q<= 4; q++){
            System.out.println("Name from row no."  + q+'1'+ " "+RowCol.get(q).getText());
        }
        //close the driver
        driver.close();
    }
}
