package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");

        //Print title
        System.out.println(driver.getTitle());


        WebElement firstName = driver.findElement(By.xpath("//input[@id = 'firstName']"));
        firstName.sendKeys("abc");
        WebElement lastName = driver.findElement(By.xpath("//input[@id = 'lastName']"));
        lastName.sendKeys("xyz");
        driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("abc@xyz.com");
        driver.findElement(By.xpath("//input[@id = 'number']")).sendKeys("9787567672");
        driver.findElement(By.cssSelector(".ui.green.button")).click();

        driver.quit();

    }
}
