import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class LMSProject_Activity7 {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/lms");

        driver.findElement(By.xpath("(//*[contains(@class,'main-header-bar-navigation')]//a)[2]")).click();

        List<WebElement> listofcourses = driver.findElements(By.xpath("//*[contains(@class,'entry-title')]"));


        System.out.println(" list of courses " + listofcourses.size());



            driver.close();

    }

}