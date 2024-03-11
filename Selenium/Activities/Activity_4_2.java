package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_4_2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.training-support.net/selenium/simple-form");

        
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        WebElement firstName = driver.findElement(By.xpath("//input[@id = 'firstName']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id = 'lastName']"));
 
        firstName.sendKeys("Swathi");
        lastName.sendKeys("N");

        driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("swathi@ibm.com");

        driver.findElement(By.xpath("//input[@id = 'number']")).sendKeys("1234567890");

        driver.findElement(By.xpath("//textarea")).sendKeys("This is my message");

        driver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();

	}

}
