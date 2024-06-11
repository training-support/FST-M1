package Actiities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find and click the button to open the alert
        driver.findElement(By.id("confirm")).click();

        // Switch focus to the alert
        Alert confirmAlert = driver.switchTo().alert();

        // Print the text in the alert
        String alertText = confirmAlert.getText();
        System.out.println("Text in alert: " + alertText);

        // Close the alert by clicking OK
        confirmAlert.accept();

        // Can also close the alert by clicking Cancel
        // confirmAlert.dismiss();

        // Close the browser
        driver.quit();
    }
}
