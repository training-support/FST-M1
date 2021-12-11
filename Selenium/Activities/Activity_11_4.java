package Activities;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_11_4 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.get("https://www.training-support.net/selenium/tab-opener");

        
        System.out.println("Page title is: " + driver.getTitle());

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window: " + parentWindow);

        driver.findElement(By.linkText("Click Me!")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("All window handles: " + allWindowHandles);

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        System.out.println("Current window handle: " + driver.getWindowHandle());

        wait.until(ExpectedConditions.titleIs("Newtab"));

        System.out.println("New Tab Title is: " + driver.getTitle());

        String newTabText = driver.findElement(By.cssSelector("div.content")).getText();
        System.out.println("New tab heading is: " + newTabText);

        driver.findElement(By.linkText("Open Another One!")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        allWindowHandles = driver.getWindowHandles();
        System.out.println("All window handles: " + allWindowHandles);

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        System.out.println("New tab handle: " + driver.getWindowHandle());

        wait.until(ExpectedConditions.titleIs("Newtab2"));

        System.out.println("New Tab Title is: " + driver.getTitle());

        newTabText = driver.findElement(By.cssSelector("div.content")).getText();
        System.out.println("New tab heading is: " + newTabText);

        driver.quit();
    }

}
