package SeleniumActivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class Activity5_3 {

    public static void main(String[] args) throws InterruptedException {

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://training-support.net/selenium/dynamic-controls");

        //Find the text box
        WebElement textInput = driver.findElement(By.xpath("//input[@type='text']"));

        //Print status
        System.out.println("The text box is enabled: " + textInput.isEnabled());
        Thread.sleep(2000);
        driver.findElement(By.id("toggleInput")).click();
        Thread.sleep(2000);
        //Print status
        System.out.println("The text box is enabled: " + textInput.isEnabled());
        textInput.sendKeys("Meena");
        //Thread.sleep(2000);
        String val=textInput.getText();
        System.out.println("Entered text in enabled text box: "+val);

        //Close the browser
        driver.close();

    }

}
