package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/nested-iframes");

        //Print title of the page
        System.out.println("Title of the page is: " + driver.getTitle());

        //Switch to first iFrame on the page
        driver.switchTo().frame(0);

        //Switch to first iFrame in that frame
        driver.switchTo().frame(0);

        //Get heading text in iFrame
        Thread.sleep(3000);
        WebElement frameHeading1 = driver.findElement(By.cssSelector("div.content"));
        System.out.println("First inside frame: "+frameHeading1.getText());

        //Switch back to parent page
        driver.switchTo().defaultContent();

        //Switch to first iFrame on the page
        driver.switchTo().frame(0);

        //Switch to second iFrame in that frame
        driver.switchTo().frame(1);

        //Get heading text in iFrame
        Thread.sleep(3000);
        WebElement frameHeading2 = driver.findElement(By.cssSelector("div.content"));
        System.out.println("Second inside frame: "+frameHeading2.getText());

        //Close browser
        driver.close();
    }
}
