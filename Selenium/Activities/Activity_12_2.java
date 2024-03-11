package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_12_2 {
	public static void main(String[] args) {
	    
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        
        driver.get("https://www.training-support.net/selenium/nested-iframes");
 
        
        System.out.println("Title of the page is: " + driver.getTitle());
 
        
        
        driver.switchTo().frame(0);
 
        
        driver.switchTo().frame(0);
 
        
        WebElement frameHeading1 = driver.findElement(By.cssSelector("div.content"));
        System.out.println(frameHeading1.getText());
 
        
        driver.switchTo().defaultContent();
 
        
        driver.switchTo().frame(0);
 
        
        driver.switchTo().frame(1);
 
        
        WebElement frameHeading2 = driver.findElement(By.cssSelector("div.content"));
        System.out.println(frameHeading2.getText());
 
       
        driver.close();
    }

}
