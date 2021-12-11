package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_8_1 {
	 public static void main(String[] args) {
		 	System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();

	        driver.get("https://training-support.net/selenium/tables");

	        List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[1]/td"));
	        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr"));

	        System.out.println("Number of columns are: " + cols.size());
	        System.out.println("Number of rows are: " + rows.size());

	        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[3]/td"));
	        for(WebElement cellValue : thirdRow) {
	            System.out.println("Cell Value: " + cellValue.getText());
	        }
	        

	        WebElement cellValue2_2 = driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]"));
	        System.out.println("Second row, second column value: " + cellValue2_2.getText());

	        driver.close();
	    }

}
