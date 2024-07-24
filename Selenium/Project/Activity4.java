package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement jobheading = driver.findElement(By.xpath("//*[@id=\"post-16\"]/div/h2"));
        String secondheading = jobheading.getText();
        System.out.println("second heading is:" + secondheading);
        if(secondheading.equals("Quia quis non")){
        driver.quit();
    }
}
}
