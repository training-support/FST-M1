package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_8_2 {
	 public static void main(String[] args) {
		 	System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();

	        driver.get("https://training-support.net/selenium/tables");

	        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th"));
	        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));

	        System.out.println("Number of columns are: " + cols.size());
	        System.out.println("Number of rows are: " + rows.size());

	        WebElement cellValueBefore = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
	        System.out.println("Second row, second column value(Before sorting): " + cellValueBefore.getText());

	        
	        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[2]")).click();

	        WebElement cellValueAfter = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
	        System.out.println("Second row, second column value(After sorting): " + cellValueAfter.getText());

	        WebElement footer = driver.findElement(By.xpath("//table[@id='sortableTable']/tfoot/tr"));
	        System.out.println("Table footer values: " + footer.getText());

	        driver.close();
	    }

}
