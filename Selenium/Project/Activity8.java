package orangeHrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity8 {
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
				driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a/img")).click();
				Select leave =new Select (driver.findElement(By.name("applyleave[txtLeaveType]")));
				leave.selectByVisibleText("privilege leaves");
				driver.findElement(By.id("applyleave_txtFromDate")).clear();
				driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2021-05-24");
				driver.findElement(By.id("applyleave_txtToDate")).clear();
				driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2021-05-25");
				Thread.sleep(3000);
				driver.findElement(By.id("applyBtn")).click();
				driver.findElement(By.id("applyBtn")).click();
				driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
				Thread.sleep(3000);
				driver.close();
	}

}
	
