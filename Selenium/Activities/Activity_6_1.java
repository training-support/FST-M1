package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_6_1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://training-support.net/selenium/dynamic-controls");

        WebElement checkbox = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input"));
        WebElement toggleCheckboxButton = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));

        toggleCheckboxButton.click();

        
        wait.until(ExpectedConditions.invisibilityOf(checkbox));

        toggleCheckboxButton.click();

        wait.until(ExpectedConditions.visibilityOf(checkbox));
        checkbox.click();

        driver.close();
	}
}
