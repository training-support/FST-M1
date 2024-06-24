import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Activity12 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of the page " + driver.getTitle());

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
