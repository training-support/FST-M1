package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static <webElement, string> void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"third-header\"]")).getText());
        //System.out.println("Third Header");
            Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5")).getCssValue("color"));
        //System.out.println("color");
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/button[3]")).getAttribute("class"));
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText());
    driver.quit();

    }}

