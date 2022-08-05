package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {

    WebDriver driver;
    @Test
    public void MenuCheck(){

        WebElement activities= driver.findElement(By.xpath("//a[@id='grouptab_3']"));

        System.out.println("activities is displayed in menu "+activities.isDisplayed());

    }

    @BeforeMethod

    public void setup(){

        //Create a new instance of the Firefox driver
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @AfterMethod

    public void tearDown()
    {

        driver.close();
    }


}
