package SeleniumActivities;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1  {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        driver.findElement(By.xpath("//a[contains(text(),'About Us')]")).click();
        System.out.println("Heading is: " + driver.getTitle());
        driver.close();
    }
}