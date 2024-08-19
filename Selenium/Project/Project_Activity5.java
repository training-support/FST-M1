package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Project_Activity5 {
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

    @Test(groups = {"Project_Activity5"})
    public void getAccountClick() {
        driver.findElement(By.linkText("My Account")).click();
        String title = driver.getTitle();
        System.out.println("Title is " + title);
       Assert.assertEquals( title,"My Account – Alchemy LMS");

    }
    @AfterClass
    public void tearDown() {
        //close the browser
        driver.quit();
    }

}

