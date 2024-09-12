package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;

    @BeforeClass

    public void setup(){
        //Installing Geckodriver
        //Initialize Firefox driver
        //Open the page

        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/login-form");

        Reporter.log("Browser opened");
    }

    @Test
    @Parameters({"username","password"})
    public void homepageTest(String username,String password){

        //System.out.println(driver.getTitle());

        //Get and assert the title of the page
        Assert.assertEquals(driver.getTitle(), "Login Form");
        Reporter.log("Home page opened");

        //Find username element
        WebElement usernamefield= driver.findElement(By.id("username"));
        //Find password element
        WebElement passwordfield= driver.findElement(By.id("password"));
        //Enter username as parameter
        usernamefield.sendKeys(username);
        //Enter password as parameter
        passwordfield.sendKeys(password);
        //click login button
        driver.findElement(By.cssSelector("button[type='submit']")).click();


    }


    @AfterClass

    public void tearDown() {
        //Close the browser
        Reporter.log("Browser closed");

        driver.quit();
    }
}