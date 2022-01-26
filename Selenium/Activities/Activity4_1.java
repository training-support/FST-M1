package org.activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {
    public static void main(String[] args)
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.training-support.net");
        String PageTitle =driver.getTitle();
        System.out.println(PageTitle);
        WebElement Link=driver.findElement(By.xpath("//a[@class='ui inverted huge green button']"));
        Link.click();
        String ChildPageTitle=driver.getTitle();
        System.out.println(ChildPageTitle);
        driver.close();
    }
}
