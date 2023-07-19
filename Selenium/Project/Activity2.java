package orangeHrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
	public static void main(String[] args) {
WebDriver driver = new FirefoxDriver();
		
		//Open the browser
		driver.get("http://alchemy.hguy.co/orangehrm\r\n");
		WebElement urlLink = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/img"));
		//String src=urlLink.getAttribute("src");
		System.out.println(urlLink.getAttribute("src"));
		driver.close();
	}

}
