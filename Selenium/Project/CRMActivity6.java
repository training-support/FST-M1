package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CRMActivity6 {

        public static void main(String[] args)
        {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            driver.get("http://alchemy.hguy.co/crm");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            driver.findElement(By.id("user_name")).sendKeys("admin");
            driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
            driver.findElement(By.id("bigbutton")).click();

            String activites1 = driver.findElement(By.xpath("//a[@id='grouptab_3']")).getText();

            if(activites1.contains("Activities"))
                System.out.println("Activites tab is exists");
            else
                System.out.println("Activites tab is not exists");



        }
    }


