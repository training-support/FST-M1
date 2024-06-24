import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity11 {

    public static void main(String[] args) {

        WebDriver driver =  new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of the page " + driver.getTitle());

        WebElement checkbox = driver.findElement(By.className("willDisappear"));
        checkbox.click();
        System.out.println("Checkbox is selected" + checkbox.isSelected());

        // deselect checkbox
        checkbox.click();
        System.out.println("Checkbox is selected: " + checkbox.isSelected());

        // Close the browser
        driver.close();
    }
}
