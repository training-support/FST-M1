
package Liveproject;

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
import java.time.Instant;
import java.util.List;

public class Activity4 {
    private FirefoxDriver driver;

    @BeforeMethod
    public void beforeMethod() {
       WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("http://alchemy.hguy.co/orangehrm");
        WebElement userName = driver.findElement(By.id("txtUsername"));
        WebElement passWord = driver.findElement(By.id("txtPassword"));
        userName.sendKeys("orange");
        passWord.sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
    }



    @Test
    public void test() {

       //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[contains(text(),'PIM')]")));
       String a = driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).getText();
       System.out.println(a);
       // driver.findElement(By.cssSelector("a[href='/orangehrm/symfony/web/index.php/directory/viewDirectory/reset/1']")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys("Sumanjali");
        driver.findElement(By.id("lastName")).sendKeys("D");
        driver.findElement(By.id("employeeId")).clear();
        driver.findElement(By.id("employeeId")).sendKeys("2708");
        driver.findElement(By.id("btnSave")).click();
        driver.navigate().back();
        driver.navigate().back();
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Sumanjali");
        driver.findElement(By.id("searchBtn")).click();
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
    driver.close();
    }
}




      /*  driver.findElement(By.xpath("//b[contains(text(),'My Info')]")).click();
        Instant wait;
        driver.findElement(By.linkText("Emergency Contacts")).click();
        List<WebElement> tableHeader = driver.findElements(By.xpath("//table[@id= 'emgcontact_list']//thead/tr[1]/th"));
        for (WebElement cellValue : tableHeader) {
            System.out.println("Table Header: " + cellValue.getText());
        }*/

