package Project.HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EditEmployee {
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
    public void EditEmployee() {
        //Login
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();


        // Editing added Employee
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Seema");
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Thaned");
        Select nationality = new Select(driver.findElement(By.id("personal_cmbNation")));
        nationality.selectByVisibleText("Indian");
        driver.findElement(By.id("btnSave")).click();

    }


    @AfterTest
    public void CloseBrowser() {
        //driver.close();

    }

}
