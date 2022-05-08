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

public class Activity9 {
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
    public void retrieveContacts() {
        driver.findElement(By.xpath("//b[contains(text(),'My Info')]")).click();
        Instant wait;
        driver.findElement(By.linkText("Emergency Contacts")).click();
        List<WebElement> tableHeader = driver.findElements(By.xpath("//table[@id= 'emgcontact_list']//thead/tr[1]/th"));
        for (WebElement cellValue : tableHeader) {
            System.out.println("Table Header: " + cellValue.getText());
        }

        List<WebElement> rowOne = driver.findElements(By.xpath("//table[@id= 'emgcontact_list']//tbody/tr[1]/td"));
        for (WebElement cellValue : rowOne) {
            System.out.println("Row One Value: " + cellValue.getText());
        }

        List<WebElement> rowTwo = driver.findElements(By.xpath("//table[@id= 'emgcontact_list']//tbody/tr[2]/td"));
        for (WebElement cellValue : rowTwo) {
            System.out.println("Row Tow Value: " + cellValue.getText());
        }

        List<WebElement> rowThree = driver.findElements(By.xpath("//table[@id= 'emgcontact_list']//tbody/tr[3]/td"));
        for (WebElement cellValue : rowThree) {
            System.out.println("Row Three Value: " + cellValue.getText());
        }
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
