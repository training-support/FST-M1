package CRM_Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity5 {
    public static void main(String[] args)
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("login page title :"+driver.getTitle());
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

        String color = driver.findElement(By.id("toolbar")).getAttribute("backgroud_color");
        System.out.println("color : "+color);
        System.out.println("size : "+driver.findElement(By.id("toolbar")).getSize());
        String color1 = driver.findElement(By.id("toolbar")).getCssValue("color");
        System.out.println("color1 : "+color1);
        String hex = Color.fromString(color1).asHex();
        System.out.println(hex);
        driver.close();
    }
}
