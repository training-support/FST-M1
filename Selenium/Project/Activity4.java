package CRM_Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) throws InterruptedException{
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://alchemy.hguy.co/crm");

        Thread.sleep( 2000);

        //Login using username and password
        WebElement userName = driver.findElement(By.id("user_name"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.id("username_password"));
        password.sendKeys("pa$$w0rd");
        driver.findElements(By.id("bigbutton")).get(0).click();

        //Verify that the homepage has opened
        Thread.sleep( 2000);
        String expectedUrl= "https://alchemy.hguy.co/crm/index.php?module=Home&action=index";

        if(driver.getCurrentUrl() != null && driver.getCurrentUrl().contains(expectedUrl))
        {
            System.out.println("Web page is opened");
        }
        else {
            System.out.println("Web page could not open.");
        }

        // Close the browser
        driver.quit();
    }
}
