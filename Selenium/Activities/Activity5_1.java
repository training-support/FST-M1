package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/dynamic-controls");

        //Find the checkbox
        WebElement checkboxInput = driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("The checkbox Input is displayed: " + checkboxInput.isDisplayed());
        
        System.out.println("The checkbox Input is selected: " + checkboxInput.isSelected());
        checkboxInput.click();
        Thread.sleep(2000);
        System.out.println("The checkbox Input is selected: " + checkboxInput.isSelected());
        
        System.out.println("The checkbox Input is displayed: " + checkboxInput.isDisplayed());
        
        driver.findElement(By.id("toggleCheckbox")).click();
        Thread.sleep(2000);
        System.out.println("The checkbox Input is displayed: " + checkboxInput.isDisplayed());

        //Close the browser
        driver.close();

    }
}
