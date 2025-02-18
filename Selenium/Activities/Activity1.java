package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;

public class Activity1 {
	public static void main(String[] args) {
		// Initialize the chrome Driver
        WebDriver driver = new ChromeDriver();

        // Open the page
        driver.get("https://training-support.net");

        // Verify the page title
        System.out.println("Page title is: " + driver.getTitle());
        // Find the About Us link and click it
        driver.findElement(By.linkText("About Us")).click();
        // Print the page title of the About Us page
        System.out.println("New page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
	}
