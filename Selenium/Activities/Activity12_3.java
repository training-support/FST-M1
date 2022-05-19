package FST_Selenium_Training.FST_Selenium_Training;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Activity12_3 {
	 public static void main(String[] args) {
	        WebDriver driver = new ChromeDriver();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        Actions builder = new Actions(driver);
	        
	        //Open browser
	        driver.get("https://www.training-support.net/selenium/popups");
	        
	        //Find Sign in button
	        WebElement button = driver.findElement(By.xpath("//button[contains(@class, 'orange')]"));
	        
	        //Hover over button
	        builder.moveToElement(button).pause(Duration.ofSeconds(1)).build().perform();
	        String tooltipText = button.getAttribute("data-tooltip");
	        System.out.println("Tooltip text: " + tooltipText);
	        
	        //Click on the button
	        button.click();
	        
	        //Wait for modal to appear
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
	        
	        //Find username and pasword and fill in the details
	        driver.findElement(By.id("username")).sendKeys("admin");
	        driver.findElement(By.id("password")).sendKeys("password");
	        driver.findElement(By.xpath("//button[text()='Log in']")).click();
	        
	        //Read the login message
	        String message = driver.findElement(By.id("action-confirmation")).getText();
	        System.out.println(message);
	        
	        //Close browser
	        driver.close();
	    }
}
