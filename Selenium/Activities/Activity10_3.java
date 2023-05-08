package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10_3 {
    public static void main(String[] args) throws InterruptedException {
        //Setup Driver
        WebDriverManager.firefoxdriver().setup();
        //Initialize the Firefox Driver
        WebDriver driver = new FirefoxDriver();
        //Webdriver wait declaration
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Initialize Actions Object
        Actions builder = new Actions(driver);

        //Open Page
        driver.get("https://www.training-support.net/selenium/drag-drop");

        //find the Football
        WebElement football = driver.findElement(By.id("draggable"));
        //find the dropzone1
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        //find the dropzone2
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
        //Perform drag and drop
        builder.clickAndHold(football).moveToElement(dropzone1).pause(2000).release().build().perform();
        Thread.sleep(5000);
        builder.dragAndDrop(football, dropzone2).build().perform();

        Thread.sleep(5000);

        driver.quit();
    }
}
