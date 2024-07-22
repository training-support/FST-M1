package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Project_Activity4 {
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

    @Test(groups = {"Project_Activity4"})
    public void getTitle() {
        String title = driver.findElement(By.xpath("//article[@id='post-71']/div/h3")).getText();
        System.out.println("Title is " + title);
        Assert.assertEquals( title,"Email Marketing Strategies");

    }
    @AfterClass
    public void tearDown() {
        //close the browser
        driver.quit();
    }

}

