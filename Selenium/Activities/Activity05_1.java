package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;

public class Activity05_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("Page Title is : "+ driver.getTitle());

        WebElement checkBoxInput = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/input"));
        System.out.println("The checkbox is displayed : "+ checkBoxInput.isDisplayed());

        driver.findElement(By.id("toggleCheckbox")).click();

        System.out.println("The checkbox Input is displayed: " + checkBoxInput.isDisplayed());
        driver.close();
    }
}
