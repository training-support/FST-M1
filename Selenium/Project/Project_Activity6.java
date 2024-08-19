package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Project_Activity6 {
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

    @Test(groups = {"Project_Activity6"})
    public void accountLogin() {
        driver.findElement(By.linkText("My Account")).click();
        String title = driver.getTitle();
        System.out.println("Title is " + title);
        Assert.assertEquals(title, "My Account – Alchemy LMS");
        driver.findElement(By.xpath("//a[@href='#login']")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        String heading = driver.findElement(By.xpath("//h1[contains(@class,'uagb-ifb-title')]")).getText();
        System.out.println("Title is " + heading);
        Assert.assertEquals(heading, "My Account");

    }

    @AfterClass
    public void tearDown() {
        //close the browser
        driver.quit();
    }

}

