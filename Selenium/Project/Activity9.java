import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.List;

public class Activity9 {
    @Test
    public void activity9TestCase() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='firstLevelMenu']/b[text()='My Info']")).click();
        driver.findElement(By.xpath("//a[text()='Emergency Contacts']")).click();
        Thread.sleep(3000);
        List<WebElement> name =driver.findElements(By.xpath("//table[contains(@id, 'emgcontact_list')]/tbody/tr/td[2]"));
        for(WebElement cell : name) {
            System.out.println("Name :"+ cell.getText());
        }
        List<WebElement> relation =driver.findElements(By.xpath("//table[contains(@id, 'emgcontact_list')]/tbody/tr/td[3]"));
        for(WebElement cell : relation) {
            System.out.println("Relation :"+ cell.getText());
        }
        List<WebElement> hometele =driver.findElements(By.xpath("//table[contains(@id, 'emgcontact_list')]/tbody/tr/td[4]"));
        for(WebElement cell : hometele) {
            System.out.println("The Home telephone number is :"+ cell.getText());
        }
        List<WebElement> mobilenum =driver.findElements(By.xpath("//table[contains(@id, 'emgcontact_list')]/tbody/tr/td[5]"));
        for(WebElement cell : mobilenum) {
            System.out.println("The mobile number is :"+ cell.getText());
        }
        List<WebElement> worktele =driver.findElements(By.xpath("//table[contains(@id, 'emgcontact_list')]/tbody/tr/td[6]"));
        for(WebElement cell : worktele) {
            System.out.println("The work telephone number is :"+ cell.getText());
        }
        driver.close();

    }
}