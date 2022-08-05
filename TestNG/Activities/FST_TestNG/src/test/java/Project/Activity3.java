package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 extends BaseClass {


    @Test

    public void copyrighttext() {

        String copytext = driver.findElement(By.id("admin_options")).getText();
        System.out.println("copyright text is: " + copytext);

    }

}
