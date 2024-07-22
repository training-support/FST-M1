package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity12 {
    public static void main(String[] args) {
        // Installing the Geckoo driver
        WebDriverManager.firefoxdriver().setup();
        // Create webdriver object
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // open a page
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Home page title: " + driver.getTitle());
        // Find the text field
        WebElement textbox = driver.findElement(By.id("input-text"));
        //WebElement textbox = driver.findElement(By.id("toggleInput"));
        //Check if it is enabled
        System.out.println("Input field is enabled : " + textbox.isEnabled());
        // Click the toggle button to enable it
        driver.findElement(By.id("toggleInput")).click();
        // Check if the text field is enabled
        System.out.println("Input field is enabled: " + textbox.isEnabled());
        driver.quit();
    }
}
