package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        // Installing the Geckoo driver
        WebDriverManager.firefoxdriver().setup();
        // Create webdriver object
        WebDriver driver = new FirefoxDriver();
        // open a page
        driver.get("https://v1.training-support.net/selenium/login-form");
        //Print Page Title
        System.out.println("Page Title: " + driver.getTitle());
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String msg = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login Message: " + msg);
        driver.quit();

    }
}
