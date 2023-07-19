package orangeHrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {
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
				driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[9]/a")).click();
				driver.findElement(By.id("addWorkExperience")).click();
				driver.findElement(By.id("experience_employer")).sendKeys("IBM INDIA PVT LTD.");
				driver.findElement(By.id("experience_jobtitle")).sendKeys("AUTOMATION TESTER");
				driver.findElement(By.id("btnWorkExpSave")).click();
				driver.close();
	}

}
