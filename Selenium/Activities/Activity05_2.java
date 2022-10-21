package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity05_2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://training-support.net/selenium/dynamic-controls");

        System.out.println("Page title is : "+ driver.getTitle());

        WebElement checkboxInput = driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("The checkbox is selected: " + checkboxInput.isSelected());

        //Select the checkbox
        checkboxInput.click();

        System.out.println("The checkbox is selected: " + checkboxInput.isSelected());

        //Close the browser
        driver.close();

    }

}