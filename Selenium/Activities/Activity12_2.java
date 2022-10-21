package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_2 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/nested-iframes");
        System.out.println("Title of the page is: " + driver.getTitle());

        driver.switchTo().frame(0);

//        WebElement frameHeading =  driver.findElement(By.xpath("/html/body/div[1]/div/div/div"));

        WebElement frameHeading = driver.findElement(By.cssSelector("div.content"));
        System.out.println("Heading of first Frame is : "+ frameHeading.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);

        driver.switchTo().frame(1);

//        WebElement frameHeading1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div"));
        WebElement frameHeading1 = driver.findElement(By.cssSelector("div.content"));

        System.out.println("Heading of second Frame is : " + frameHeading1.getText());

        driver.close();
    }
}
