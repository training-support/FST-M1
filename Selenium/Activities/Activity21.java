package activities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity21 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://v1.training-support.net/selenium/tab-opener");

        System.out.println("New Tab is :" + driver.getTitle());
        Thread.sleep(20);
        System.out.println("Handle of the page is: " + driver.getWindowHandle());
        Thread.sleep(20);
        driver.findElement(By.id("launcher")).click();
        System.out.println("Current tabs are: " + driver.getWindowHandles());

        for (String handle: driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        Thread.sleep(20);
        System.out.println("New Tab is :" + driver.getTitle());
        System.out.println("Handle of the page is: " + driver.getWindowHandle());
        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton"))).click();
        System.out.println("Current tabs are: " + driver.getWindowHandles());

        for (String handle: driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        Thread.sleep(20);
        System.out.println("Title of the page is :" + driver.getTitle());
    }
}
