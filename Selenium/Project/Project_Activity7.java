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

public class Project_Activity7 {
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

    @Test(groups = {"Project_Activity7"})
    public void courseCount() {
        driver.findElement(By.linkText("All Courses")).click();
        String title = driver.getTitle();
        System.out.println("The Title is" + title);
        String Course1 = driver.findElement(By.xpath("//h3[text()='Social Media Marketing']")).getText();
        String Course2 = driver.findElement(By.xpath("//h3[text()='Email Marketing Strategies']")).getText();
        String Course3 = driver.findElement(By.xpath("//h3[text()='Content Marketing']")).getText();
        System.out.println("List of Course :" + "\n" + Course1 + "\n" + Course2 + "\n" + Course3);
    }

    @AfterClass
    public void tearDown() {
        //close the browser
        driver.quit();
    }

}

