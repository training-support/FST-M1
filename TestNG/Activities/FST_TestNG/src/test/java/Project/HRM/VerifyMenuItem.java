package Project.HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VerifyMenuItem {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void OpenBrowser() {

        //Create a new instance of the Firefox driver
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm\n");

    }


    @Test
    public void VerifyMenu() {
        //Login
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();


        // Verify Menu Directory added Employee
        driver.findElement(By.id("menu_directory_viewDirectory")).click();
        WebElement Directory=driver.findElement(By.id("menu_directory_viewDirectory"));
        if (Directory.isEnabled() && Directory.isDisplayed())
        {
            Directory.click();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       // WebElement Search=driver.findElement(By.id("menu_directory_viewDirectory"));
        //String Search = driver.findElement(By.xpath("//div[contains(@class='head')]/h1")).getText();

        WebElement Search=driver.findElement(By.tagName("h1"));
        String Directoryheader=Search.getText();
        System.out.println(Directoryheader);
        Assert.assertEquals(Directoryheader,"Search Directory");
    }


    @AfterTest
    public void CloseBrowser() {
        //driver.close();

    }

}
