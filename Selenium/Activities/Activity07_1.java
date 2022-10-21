package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity07_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        //Open browser
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        System.out.println("Paget title is : "+ driver.getTitle());
        //Find username and password fields
        WebElement userName = driver.findElement(By.xpath("//input[starts-with(@class, 'username')]"));
        WebElement password = driver.findElement(By.xpath("//input[contains(@class, 'password')]"));
        //Type credentials
        userName.sendKeys("admin");
        password.sendKeys("password");

        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();

        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);

        //Close browser
        driver.close();

    }
}