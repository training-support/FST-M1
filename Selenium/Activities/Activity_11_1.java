package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_11_1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.training-support.net/selenium/javascript-alerts");
 
        driver.findElement(By.cssSelector("button#simple")).click();

        Alert simpleAlert = driver.switchTo().alert();

        
        String alertText = simpleAlert.getText();
        System.out.println("Alert text is: " + alertText);

        simpleAlert.accept();

        driver.close();
    }
}
