package orangeHrm;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity9 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
				
				//Open the browser
				driver.get("http://alchemy.hguy.co/orangehrm\r\n");
				WebElement username = driver.findElement(By.id("txtUsername"));
				WebElement password = driver.findElement(By.id("txtPassword"));
				username.sendKeys("orange");
				password.sendKeys("orangepassword123");
				driver.findElement(By.id("btnLogin")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[6]/a/b")).click();
				driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a")).click();
				//List<WebElement> cols = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
				//Number of columns
				//System.out.println(cols.size());
				List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
				//Number of rows
				//System.out.println(rows.size());
				for(int i=1; i<=rows.size(); i++) {
				    WebElement row = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]"));
				    System.out.println("Row " + i + ": " + row.getText());
				    
				    
	}

driver.close();
}
}
