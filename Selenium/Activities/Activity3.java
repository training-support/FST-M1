package org.activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args)
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        String Pagetitel =driver.getTitle();
        System.out.println(Pagetitel);
        WebElement Fname =driver.findElement(By.id("firstName"));
        Fname.sendKeys("venkatramireddy");
        WebElement Lname =driver.findElement(By.id("lastName"));
        Lname.sendKeys("Mareddy");
        WebElement Email=driver.findElement(By.id("email"));
        Email.sendKeys("Ramireddy591@gmail.com");
        WebElement Pnumber=driver.findElement(By.id("number"));
        Pnumber.sendKeys("9989593467");
        WebElement Submit=driver.findElement(By.xpath("//input[@type='submit']"));
        System.out.println("Click on submit button");
        Submit.click();
        System.out.println("Close the browser");
        // driver.close();
         driver.quit();


    }
}
