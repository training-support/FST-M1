package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_11_3 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.training-support.net/selenium/javascript-alerts");

        System.out.println("Page title is: " + driver.getTitle());

        driver.findElement(By.cssSelector("button#prompt")).click();

        Alert promptAlert = driver.switchTo().alert();

        
        String alertText = promptAlert.getText();
        System.out.println("Alert text is: " + alertText);

        promptAlert.sendKeys("Hello");

        promptAlert.accept();

        driver.close();
    }

}
