package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        Actions builder = new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/input-events");
        System.out.println("Title of the page: " + driver.getTitle());

        builder.click().pause(1000).build().perform();
        String text1 = driver.findElement(By.className("active")).getText();
        System.out.println("First value in front side: " +text1);

        builder.doubleClick().pause(1000).build().perform();
        String text2 = driver.findElement(By.className("active")).getText();
        System.out.println("Value on double click: " +text2);

        builder.contextClick().pause(1000).build().perform();
        String text3 = driver.findElement(By.className("active")).getText();
        System.out.println("Value on Right click: " +text3);

        driver.close();
    }
}
