package SeleniumActivities;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/simple-form");

        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        
        Thread.sleep(5000);
        firstName.sendKeys("Meena");
        lastName.sendKeys("Dhandapani");
        Thread.sleep(5000);
        System.out.println("First Name: "+firstName.getAttribute("value"));
        System.out.println("Last Name: "+lastName.getAttribute("value"));
        
        driver.findElement(By.id("email")).sendKeys("meena@test.com");
        Thread.sleep(6000);
        System.out.println("Email Value: "+driver.findElement(By.id("email")).getAttribute("value"));
        
        driver.findElement(By.id("number")).sendKeys("1234567890");
        Thread.sleep(5000);
        System.out.println("Number Value: "+driver.findElement(By.id("number")).getAttribute("value"));
        
        System.out.println("Button Name: "+driver.findElement(By.cssSelector("input.green")).getAttribute("value"));
        driver.findElement(By.cssSelector("input.green")).click();
        Thread.sleep(5000);
        
        if(driver.switchTo().alert() != null) {
        System.out.println("Alert is displayed: "+ driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        }
       // driver.close();
    }
}
