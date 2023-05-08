package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/");

        //Print title
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//a[@id=\"about-link\"]")).click();

        //Print title
        System.out.println(driver.getTitle());

        driver.quit();

    }
}
