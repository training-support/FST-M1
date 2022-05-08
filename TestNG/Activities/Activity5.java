package Liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Activity5 {
    private FirefoxDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("http://alchemy.hguy.co/orangehrm");
        WebElement userName = driver.findElement(By.id("txtUsername"));
        WebElement passWord = driver.findElement(By.id("txtPassword"));
        userName.sendKeys("orange");
        passWord.sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
    }
    @Test
    public void test(){
    driver.findElement(By.id("menu_pim_viewMyDetails")).click();
    driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Sumanjali Reddy");
        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Devarapalli");
        driver.findElement(By.id("personal_optGender_2")).click();
        driver.findElement(By.id("personal_DOB")).sendKeys("2022-02-05");
    driver.findElement(By.id("btnSave")).click();
    }
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
