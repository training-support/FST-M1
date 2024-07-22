package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) {
        // Installing the Geckoo driver
        WebDriverManager.firefoxdriver().setup();
        // Create webdriver object
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // open a page
        driver.get("https://v1.training-support.net/selenium/ajax");
        System.out.println("Home page title: " + driver.getTitle());
        driver.findElement(By.cssSelector("button.violet")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        String text =driver.findElement(By.tagName("h1")).getText();
        System.out.println("Hello Text : " +text);
        WebElement delayedtext = driver.findElement(By.tagName("h3"));
        System.out.println("Delayed Text :" +delayedtext.getText());
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"),"I'm late!"));
        String latetext = driver.findElement(By.tagName("h3")).getText();
        System.out.println("Late Text : "+latetext);
        driver.quit();

    }
}
