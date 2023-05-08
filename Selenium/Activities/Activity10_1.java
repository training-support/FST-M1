package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get(" https://www.training-support.net/selenium/input-events");
        Actions actions = new Actions(driver);

        //Print title
        System.out.println("title:" + driver.getTitle());

        //Main
        WebElement dice = driver.findElement(By.id("wrapD3Cube"));
        actions.click(dice).build().perform();
        WebElement Val = driver.findElement(By.className("active"));
        System.out.println("Left Click: " + Val.getText());

        actions.doubleClick(dice).build().perform();
        Val = driver.findElement(By.className("active"));
        System.out.println("Double Click: " + Val.getText());

        actions.contextClick(dice).build().perform();
        Val = driver.findElement(By.className("active"));
        System.out.println("Right Click: " + Val.getText());

        driver.quit();

    }

}
