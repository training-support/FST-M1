package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args){
        //Setup Driver
        WebDriverManager.firefoxdriver().setup();
        //Initialize the Firefox Driver
        WebDriver driver=new FirefoxDriver();
        //Open the Page
        driver.get("https://www.training-support.net/");

        System.out.println(driver.getTitle());
        WebElement element = driver.findElement(By.id("about-link"));
        System.out.println(element.getText());
        WebElement element1 = driver.findElement(By.className("green"));
        System.out.println(element1.getText());
        WebElement linkElement = driver.findElement(By.linkText("About Us"));
        System.out.println(linkElement.getText());
        WebElement idElement = driver.findElement(By.cssSelector("#about-link"));
        System.out.println(idElement.getText());

        //Close the Browser
        driver.quit();
    }
}
