package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	
WebDriver driver;
    
    @BeforeClass
    public void beforeMethod() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    
    
    @Test
    public void loginTest() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        
        
        username.sendKeys("admin");
        password.sendKeys("password");
        
       
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        
       
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals("Welcome Back, admin", loginMessage);
    }
 
    @AfterClass
    public void afterClass() {
       
        driver.close();
    }
  
}
