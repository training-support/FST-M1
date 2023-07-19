package orangeHrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
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
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a/b")).click();
		driver.findElement(By.name("btnAdd")).click();
		driver.findElement(By.name("firstName")).sendKeys("KILLER");
		driver.findElement(By.name("lastName")).sendKeys("BOND");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a/b")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("empsearch[employee_name][empName]")).sendKeys("KILLER");
		driver.findElement(By.id("searchBtn")).click();
		driver.close();
	}
}