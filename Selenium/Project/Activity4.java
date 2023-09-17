import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
public class Activity4 {
    @Test
    public void activity4TestCase() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@class='firstLevelMenu']/b)[2]")).click();
        Thread.sleep(3000);
        driver.findElement((By.id("btnAdd"))).click();
        driver.findElement(By.id("firstName")).sendKeys("NJ");
        driver.findElement(By.id("lastName")).sendKeys("King");
        driver.findElement((By.id("btnSave"))).click();
        Thread.sleep(3000);
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("NJ King");
        driver.findElement((By.id("searchBtn"))).click();
        driver.quit();
    }

}