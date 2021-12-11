package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    
        driver.get("https://www.training-support.net/selenium/simple-form");
        
        
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        
        firstName.sendKeys("Swathi");
        lastName.sendKeys("N");
        
        driver.findElement(By.id("email")).sendKeys("swathi@ibm.com");
        
        driver.findElement(By.id("number")).sendKeys("1234567890");
        
        driver.findElement(By.cssSelector(".ui.green.button")).click();
    
        driver.close();

	}

}
