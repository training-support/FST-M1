package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity18 {
    public static void main(String[] args) {
        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Open the page
        driver.get("https://training-support.net/webelements/alerts");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find and click the button to open the alert
        driver.findElement(By.id("simple")).click();

        // Switch focus to the alert
        Alert simpleAlert = driver.switchTo().alert();

        // Print the text in the alert
        String alertText = simpleAlert.getText();
        System.out.println("Text in alert: " + alertText);

        // Close the alert by clicking OK
        simpleAlert.accept();
        
        // Print the message
        System.out.println(driver.findElement(By.id("result")).getText());

        // Close the browser
        driver.quit();
    }
}
