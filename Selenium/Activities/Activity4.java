package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {
        // Installing the Geckoo driver
        WebDriverManager.firefoxdriver().setup();
        // Create webdriver object
        WebDriver driver = new FirefoxDriver();
        // open a page
        driver.get("https://v1.training-support.net/selenium/target-practice");
        //Print Page Title
        System.out.println("Page Title: " + driver.getTitle());
        String third_header =driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
        System.out.println("Third Header Text :" +third_header);
        String fifthheadercolor = driver.findElement(By.xpath("//h5[text()='Fifth header']")).getCssValue("color");
        System.out.println("Fifth header Colur :" +fifthheadercolor);
        String voiletbutton = driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
        System.out.println("Voilet button Class :" +voiletbutton);
        String greybutton = driver.findElement(By.xpath("//button[text()='Grey']")).getText();
        System.out.println("Voilet button Class :" +greybutton);
        driver.quit();

    }
}
