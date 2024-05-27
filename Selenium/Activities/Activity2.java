package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity2 {
    public static <webElement> void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Thread.sleep(2000);
        WebElement Username = driver.findElement(By.id("username"));
        ((WebElement) Username).sendKeys("admin");
        Thread.sleep(2000);
        WebElement Password = driver.findElement(By.id("password"));
        ((WebElement) Password).sendKeys("password");
        Thread.sleep(2000);
        WebElement Login = driver.findElement(By.xpath ("/html/body/div[2]/div/div[2]/div[2]/div/div/button"));
        Login.click();
        driver.quit();
    }}
