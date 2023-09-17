import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity6 {
    @Test
    public void activity6TestCase() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@class='firstLevelMenu']/b)[9]")).isDisplayed();
        driver.findElement(By.xpath("(//a[@class='firstLevelMenu']/b)[9]")).isEnabled();
        driver.findElement(By.xpath("(//a[@class='firstLevelMenu']/b)[9]")).click();
        Thread.sleep(3000);
        String header = driver.findElement(By.xpath("//div[@class='head']/h1")).getText();
        Assert.assertEquals(header, "Search Directory");
    }
}