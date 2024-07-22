package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Activity19 {
    public static void main(String[] args) {
        // Installing the Geckoo driver
        WebDriverManager.firefoxdriver().setup();
        // Create webdriver object
        WebDriver driver = new FirefoxDriver();

        Actions builder = new Actions(driver);
        // open a page
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        System.out.println("Page Title: " + driver.getTitle());
        driver.findElement(By.id("confirm")).click();

        Alert confirmalert = driver.switchTo().alert();
        System.out.println("Alert Message" + confirmalert.getText());
        confirmalert.accept();
        driver.quit();

    }
}
