package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7_2 {

WebDriver driver;
WebDriverWait wait;


    @Test

    public void ReadMenuItem(){

        // Opening Leads under Sales

        driver.findElement(By.id("grouptab_0")).click();
        driver.findElement(By.id("moduleTab_9_Leads")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[10]/span[1]/span[1]")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Additional Details']")));
        //driver.findElement(By.xpath("//tbody/tr[1]/td[10]/span[1]/span[1]")).click();
        driver.findElement(By.xpath("//span[@title='Additional Details']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='phone']")));
        WebElement phone = driver.findElement(By.xpath("//span[@class='phone']"));
        System.out.println("The number is: " + phone.getText());

    }


    @BeforeMethod

    public void setup(){

        //Create a new instance of the Firefox driver
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/crm/");

        //Login
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
    }

    @AfterMethod

    public void tearDown()
    {

        driver.close();
    }


}
