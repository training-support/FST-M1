package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CRMActivity4 {

    public static void main(String[] args)
    {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        //verifying the homepage is displayed or not
        if(driver.findElement(By.xpath("//a[text()='Sales']")).isDisplayed()){
            System.out.println("Home Page is displayed");
        }else{
            System.out.println("Home Page is not displayed");
        }
        driver.close();


    }
}
