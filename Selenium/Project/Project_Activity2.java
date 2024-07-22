package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Project_Activity2 {
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

    @Test(groups = {"Project_Activity2"})
    public void getHeader() {
        String heading = driver.findElement(By.xpath("//h1[contains(@class,'uagb-ifb-title')]")).getText();
        System.out.println("Heading is " + heading);
        Assert.assertEquals( heading,"Learn from Industry Experts");

    }
    @AfterClass
    public void tearDown() {
        //close the browser
        driver.quit();
    }

}

