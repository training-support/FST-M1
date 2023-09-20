package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CRMActivity2 {

    public static void main (String[] args){

        //webdriver setup

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement headImgUrl = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
        System.out.println("header url is:" +headImgUrl.getAttribute("href"));

        WebElement headImgUrl1 = driver.findElement(By.xpath("//a[@title='SuiteCRM']"));
        System.out.println("header url is:" +headImgUrl1.getAttribute("href"));

        driver.close();





    }
}
