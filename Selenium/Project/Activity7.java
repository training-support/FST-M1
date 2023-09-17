import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity7 {
    @Test
    public void activity7TestCase() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@class='firstLevelMenu']/b)[6]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[text()='Qualifications'])[2]")).click();
        driver.findElement(By.xpath("//input[@id='addWorkExperience']")).click();
        driver.findElement(By.id("experience_employer")).sendKeys("ABC International");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Developer");
        driver.findElement(By.xpath("//input[@id='experience_from_date']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='experience_from_date']")).sendKeys("2021-07-19");
        driver.findElement(By.xpath("//input[@id='experience_to_date']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='experience_to_date']")).sendKeys("2023-08-08");
        driver.findElement(By.id("btnWorkExpSave")).click();
        driver.quit();
    }
}