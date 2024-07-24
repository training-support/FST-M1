
package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1_2 {

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement heading = driver.findElement(By.xpath("//*[@id=\"post-16\"]/header/h1"));
        String headingText = heading.getText();
        System.out.println("heading text is: " + headingText);
       if (headingText.equals("Welcome to Alchemy Jobs")) {
        driver.quit();
      }

    }
    }



