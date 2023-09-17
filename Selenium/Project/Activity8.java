import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class Activity8 {
    @Test
    public void activity8TestCase() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Apply Leave']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//select[@name='applyleave[txtLeaveType]']"));
        Select dropdown = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        dropdown.selectByVisibleText("DayOff");
        driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']")).sendKeys("2023-09-01");
        driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']")).clear();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']")).sendKeys("2023-09-15");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//p[text()[contains(.,'Apply')]]")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        driver.findElement(By.xpath("//input[@id='calFromDate']")).clear();
        driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']")).clear();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='calFromDate']")).sendKeys("2023-09-01");
        driver.findElement(By.xpath("//input[@id='calToDate']")).sendKeys("2023-09-15");
        Thread.sleep(3000);
        driver.findElement(By.id("btnSearch"));
        driver.close();
    }
}