package CRM_Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

//login into site
        driver.get("http://alchemy.hguy.co/crm");
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

//getting into sales tab and then leads tab
        driver.findElement(By.id("grouptab_0")).click();
        driver.findElement(By.id("moduleTab_9_Leads")).click();

//scrolling left till the end of page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

//waiting till element is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id = 'edit-6af2edb0-bc40-46d1-7837-5fdc647a1061']")));

//clicking on additional information icon
        driver.findElement(By.xpath("//span[@class = 'suitepicon suitepicon-action-info']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='phone']")));

//getting phone number from additional information window
        String phone =driver.findElement(By.xpath("//span[@class='phone']")).getText();
        System.out.println("phone no is : "+phone);
        driver.close();

    }
}
