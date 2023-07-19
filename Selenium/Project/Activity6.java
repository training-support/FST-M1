package orangeHrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {
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
		String exact="Search Directory";
		WebElement element=driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[9]/a/b"));
		if(element.isDisplayed() && element.isEnabled()) {
			System.out.println("Displaying and Clickable");
			element.click();
		}
		String title=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/h1")).getText();
		if(title.equals(exact)) {
			System.out.println(title);
			driver.close();
		}
		else {
			System.out.println("not maching");
			driver.close();
		}
		
	}
}