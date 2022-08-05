package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {

    WebDriver driver;
    @Test

    public void GetColors(){
        String navigationmenurColour = driver.findElement(By.xpath("//div[@id='toolbar']")).getCssValue("color");
        System.out.println("home pagetoolbar color is : " + navigationmenurColour);

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
