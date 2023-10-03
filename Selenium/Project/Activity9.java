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

public class Activity9 {
    public static void main (String[] args)
    {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

//login into site
        driver.get("http://alchemy.hguy.co/crm");
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

//getting into sales tab and then accounts tab
        driver.findElement(By.id("grouptab_0")).click();
        driver.findElement(By.id("moduleTab_9_Leads")).click();

//wait till element is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pagination")));

//getting the table element
        WebElement tbl = driver.findElement(By.xpath("//table[@class='list view table-responsive']"));

//getting the count of rows
        List<WebElement> rows = tbl.findElements(By.xpath("//table/tbody/tr"));
        System.out.println("no of rows :" + rows.size());

        List<WebElement> cols = tbl.findElements(By.xpath("//table/thead/tr/th"));
        System.out.println("no. of columns : "+cols.size());

        List<WebElement> firstcol = tbl.findElements(By.xpath("//table/tbody/tr/td[3]"));
        System.out.println("no. of rows in 3rd col : "+firstcol.size());

        List<WebElement> ninethCol = tbl.findElements(By.xpath("//table/tbody/tr/td[8]"));
        System.out.println("no. of rows in 8th col : "+ninethCol.size());

        for (int i =1; i<=10 ;i++)
        {
            //System.out.println("name : "+firstcol.get(i).getText());
            System.out.println("|name:| " + firstcol.get(i).getText() +" "+"|user:| " + ninethCol.get(i-1).getText());

        }

        driver.close();
    }
}
