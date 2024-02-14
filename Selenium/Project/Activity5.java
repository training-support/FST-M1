package Project_LMS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;

    @BeforeMethod
    public void InitializationOfDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }
    @Test
    public void exampleTestCase() throws Exception{


        WebElement MyAccount = driver.findElement(By.xpath("//div[@class='main-navigation']/ul//li[@id='menu-item-1507']/a"));

        //Print the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        MyAccount.click();

        //Assertion for page title
        System.out.println("Page title is: " + driver.getTitle());

        Assert.assertEquals("My Account – Alchemy LMS",driver.getTitle());

    }

    @AfterMethod
    public void ClosingOfDriver()
    {
        if(driver.getTitle().equals("My Account – Alchemy LMS")) {
            driver.close();
        }
    }

}
