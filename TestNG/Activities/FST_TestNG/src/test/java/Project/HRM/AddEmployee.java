package Project.HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddEmployee {

    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    public void OpenBrowser(){

        //Create a new instance of the Firefox driver
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm\n");

    }


    @Test
    public void GetTitle(){
        //Get Title
        String title = driver.getTitle();
        Assert.assertEquals("OrangeHRM", title);
        System.out.println("Title :"+title);


      //GetHeaderURL
        WebElement url=driver.findElement(By.tagName("img"));
        String src = url.getAttribute("src");
        System.out.println("The URL of the Header Image is" + src);

        //Login
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        //Adding Leave Request

        //driver.findElement(By.id("menu_pim_viewPimModule")).click();
        //driver.findElement(By.xpath("//a[contains(@href,'viewPimModule')]")).click();
        driver.findElement(By.cssSelector("#menu_pim_viewPimModule > b:nth-child(1)")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewEmployeeList")));
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys("Seema");
        driver.findElement(By.id("lastName")).sendKeys("Thaned");
        driver.findElement(By.id("btnSave")).click();
// Verifying Employee added
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Seema Thaned");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBtn")));
        driver.findElement(By.id("searchBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));
        String ExpectedName = driver.findElement(By.xpath("//tr[contains(@class,'odd')]")).getText();
        System.out.println(ExpectedName);

    }

    @AfterTest
    public void CloseBrowser(){
        //driver.close();

    }
}
