package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_10_3 {
	public static void main(String[] args) throws InterruptedException {
	    
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        
        driver.get("https://training-support.net/selenium/drag-drop");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("draggable")));

        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement drop1 = driver.findElement(By.id("droppable"));
        WebElement drop2 = driver.findElement(By.id("dropzone2"));

        Actions dragAndDrop = new Actions(driver);
        dragAndDrop.dragAndDrop(ball, drop1).build().perform();

        wait.until(ExpectedConditions.attributeToBeNotEmpty(drop1, "background-color"));
        System.out.println("ENTERED DROPZONE 1");

        dragAndDrop.dragAndDrop(ball, drop2).build().perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(drop2, "background-color"));
        System.out.println("ENTERED DROPZONE 2");

        driver.close();
    }

}
