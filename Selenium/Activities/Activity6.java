package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity6 {
    public static void main(String[] args) {
        // Installing the Geckoo driver
        WebDriverManager.firefoxdriver().setup();
        // Create webdriver object
        WebDriver driver = new FirefoxDriver();
        //Create action Object
        Actions builder = new Actions(driver);
        // open a page
        driver.get("https://v1.training-support.net/selenium/input-events");
        //Print Page Title
        System.out.println("Page Title: " + driver.getTitle());

        // Press the key
        builder.sendKeys("M").build().perform();
        // Press CTRL+A and CTRL+C
        builder.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        // Close the browser
        driver.close();;

    }
}
