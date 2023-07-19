package orangeHrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity5 {
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
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("personal_txtEmpFirstName")).clear();
		driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Killer");
		driver.findElement(By.id("personal_txtEmpLastName")).clear();
		driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Bond");
		driver.findElement(By.id("personal_optGender_1")).click();
		Select dropcountry =new Select (driver.findElement(By.name("personal[cmbNation]")));
		dropcountry.selectByVisibleText("Indian");
		driver.findElement(By.id("personal_DOB")).clear();
		driver.findElement(By.id("personal_DOB")).sendKeys("1996-04-26");
		driver.findElement(By.id("btnSave")).click();
		driver.close();
		
	}	

}
