package activities;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Activity12 {
    public static void main(String[] args) {

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://www.training-support.net/selenium/dynamic-controls");

        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find the text field
        WebElement textbox = driver.findElement(By.id("input-text"));
        // Check if it is enabled
        System.out.println("Input field is enabled: " + textbox.isEnabled());
        // Click the toggle button to enable it
        driver.findElement(By.id("toggleInput")).click();
        // Check if the text field is enabled
        System.out.println("Input field is enabled: " + textbox.isEnabled());

        // Close the browser
        driver.close();
    }
}
