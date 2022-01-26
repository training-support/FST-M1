package org.activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=null;
        driver=new FirefoxDriver();
        driver.get(" https://www.training-support.net/selenium/simple-form");
        String PageTitle=driver.getTitle();
        System.out.println("print the pagetitle :" +PageTitle);

        WebElement Fname=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        Fname.sendKeys("venkataramireddy");
        WebElement Lname= driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        Lname.sendKeys("Mareddy");
        WebElement Email=driver.findElement(By.xpath("//input[@placeholder='abc@xyz.com']"));
        Email.sendKeys("Ramireddy591@gmail.com");
        WebElement Pnumber=driver.findElement(By.xpath("//input[@placeholder='9876543210']"));
        Pnumber.sendKeys("9989593467");
        WebElement Message=driver.findElement(By.xpath("//textarea"));
        Message.sendKeys("My name is venkataramireddy mareddy along with my contact number:9989593467");
        WebElement Submit=driver.findElement(By.xpath("//input[@class='ui green button']"));
        Submit.click();
        System.out.println("Done");
        Thread.sleep(2000);
        driver.quit();
    }
}
