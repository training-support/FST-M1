package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_7_1 {
	public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        //Open browser
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        
        WebElement userName = driver.findElement(By.xpath("//input[starts-with(@class, 'username')]"));
        WebElement password = driver.findElement(By.xpath("//input[contains(@class, 'password')]"));

        userName.sendKeys("admin");
        password.sendKeys("password");

        
        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
        
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);

        driver.close();
 
    }

}
