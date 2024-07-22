package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {
    public static void main(String[] args) {
        // Installing the Geckoo driver
        WebDriverManager.firefoxdriver().setup();
        // Create webdriver object
        WebDriver driver = new FirefoxDriver();

        Actions builder = new Actions(driver);
        // open a page
        driver.get("https://v1.training-support.net/selenium/drag-drop");

        WebElement football = driver.findElement(By.id("draggable"));
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

        builder.dragAndDrop(football, dropzone1).build().perform();

        builder.clickAndHold(football).moveToElement(dropzone2).release().build().perform();

        String dropzone1test = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
        System.out.println("Football Dropzone 1 confirmed " + dropzone1test );
        String dropzone2test = driver.findElement(By.xpath("//div[@id='dropzone2']/p")).getText();
        System.out.println("Football Dropzone 2 confirmed " + dropzone2test );
        driver.quit();

    }
}
