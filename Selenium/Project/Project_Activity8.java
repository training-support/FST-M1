package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Project_Activity8{
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        //Setup Gecko driver
        WebDriverManager.firefoxdriver().setup();
        //Initialize Firefox
        driver = new FirefoxDriver();
        // Open Browser
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test(groups = {"Project_Activity8"})
    public void contactAdmin() {
        driver.findElement(By.linkText("Contact")).click();
        driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Mokshith K Suvarna");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.findElement(By.id("wpforms-8-field_1")).sendKeys("mok@mok.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.findElement(By.id("wpforms-8-field_3")).sendKeys("Selenium Project");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.findElement(By.id("wpforms-8-field_2")).sendKeys("Completing the Selenium Project");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.findElement(By.xpath("//button[text()=\"Send Message\"]")).click();
    }
    @AfterClass
    public void tearDown() {
        //close the browser
        driver.quit();
    }

}

