package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_5_2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.training-support.net/selenium/dynamic-controls");

        WebElement checkboxInput = driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("The checkbox is selected: " + checkboxInput.isSelected());

        checkboxInput.click();

        System.out.println("The checkbox is selected: " + checkboxInput.isSelected());

        driver.close();

        
	}

}
