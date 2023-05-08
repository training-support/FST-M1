package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");

        //Print title
        System.out.println(driver.getTitle());

        WebElement text=driver.findElement(By.xpath("//input[@type='text']"));
        if (text.isEnabled())
            System.out.println("text box enabled");
        else
            System.out.println("text box not enabled");

        driver.findElement(By.id("toggleInput")).click();
        Thread.sleep(2000);

        if (text.isEnabled())
            System.out.println("text box enabled");
        else
            System.out.println("text box not enabled");

        driver.quit();
    }
}
