package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args){
        //Setup Driver
        WebDriverManager.firefoxdriver().setup();
        //Initialize the Firefox Driver
        WebDriver driver=new FirefoxDriver();
        //Open the Page
        driver.get("https://www.training-support.net/");
        //Close the Browser
        driver.quit();
    }
}
