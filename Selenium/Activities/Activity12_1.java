package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_1 {
    public static void main(String[] args) {

        //Create WebDriver instance
        WebDriver driver = new FirefoxDriver();

        //Open browser
        driver.get("https://www.training-support.net/selenium/iframes");

        //Print title of the page
        System.out.println("Title of the page is: " + driver.getTitle());

        //Switch to first iFrame on the page
        driver.switchTo().frame(0);

        //Perform operation on the first frame
        WebElement frameHeading1 = driver.findElement(By.cssSelector("div.content"));
        System.out.println(frameHeading1.getText());

        //Click button in iFrame 1
        WebElement button1 = driver.findElement(By.cssSelector("button"));
        System.out.println(button1.getText());
        System.out.println(button1.getCssValue("background-color"));
        button1.click();

        //Print New Button Info
        System.out.println(button1.getText());
        System.out.println(button1.getCssValue("background-color"));

        //Switch back to parent page
        driver.switchTo().defaultContent();

        //Switch to second iFrame on the page
        driver.switchTo().frame(1);

        //Perform operation on the second frame
        WebElement frameHeading2 = driver.findElement(By.cssSelector("div.content"));
        System.out.println(frameHeading2.getText());

        //Click button in iFrame 2
        WebElement button2 = driver.findElement(By.cssSelector("button"));
        System.out.println(button2.getText());
        System.out.println(button2.getCssValue("background-color"));
        button2.click();

        //Print New Button Info
        System.out.println(button2.getText());
        System.out.println(button2.getCssValue("background-color"));

        //Switch back to parent page
        driver.switchTo().defaultContent();

        //Close browser
        driver.close();
    }
}