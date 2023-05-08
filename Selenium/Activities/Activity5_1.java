package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");

        //Print title
        System.out.println(driver.getTitle());


        if (driver.findElement(By.className("willDisappear")).isDisplayed())
            System.out.println("Checkbox present");
        else
            System.out.println("Checkbox absent");

        driver.findElement(By.id("toggleCheckbox")).click();

        if (driver.findElement(By.className("willDisappear")).isDisplayed())
            System.out.println("Checkbox present");
        else
            System.out.println("Checkbox absent");

        driver.quit();
    }

}
