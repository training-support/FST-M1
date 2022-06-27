package SeleniumActivities;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_2  {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        WebElement idLocator = driver.findElement(By.id("about-link"));
        System.out.println("Text in element using id: " + idLocator.getText());

        WebElement classNameLocator = driver.findElement(By.className("green"));
        System.out.println("Text in element using className: " + classNameLocator.getText());

        WebElement cssLocator = driver.findElement(By.cssSelector(".green"));
        System.out.println("Text in element using cssLocator: " + cssLocator.getText());

        WebElement linkTextLocator = driver.findElement(By.linkText("About Us"));
        System.out.println("Text in element using linkText: " + linkTextLocator.getText());

        driver.close();
        driver.quit();
    }
}
