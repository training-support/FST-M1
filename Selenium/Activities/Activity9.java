package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.tagName;

public class Activity9 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/ajax");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.className("violet")).click();
        String heading1 = wait.until(ExpectedConditions.visibilityOfElementLocated(tagName("h1"))).getText();
        System.out.println("New h1 tag: " + heading1);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(tagName("h3"), "I'm late"));
        String heading3 = driver.findElement(tagName("h3")).getText();
        System.out.println("New he says:" + heading3);
        driver.quit();
    }
}
