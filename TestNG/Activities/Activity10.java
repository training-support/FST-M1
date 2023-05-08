package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
public class Activity10 {
    WebDriver driver;
    WebDriverWait wait;
    Actions builder;
    @BeforeClass(alwaysRun = true)
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        builder=new Actions(driver);
        //OPen the Page
        driver.get("https://www.training-support.net/selenium/sliders");
    }
    @Test(priority=1)
    public void middleValueTest(){
        WebElement slider = driver.findElement(By.id("slider"));
        slider.click();
        WebElement val = driver.findElement(By.xpath("//span[@id='value']"));
        String volume= val.getText();
        System.out.println("Value" +volume);
        Assert.assertEquals(volume, "50");
    }
    @Test(priority=2)
    public void maxValueTest(){
        WebElement slider = driver.findElement(By.id("slider"));
        builder.clickAndHold(slider).moveByOffset(75, 0).release();
                builder.build().perform();
        WebElement val = driver.findElement(By.xpath("//span[@id='value']"));
        String volume= val.getText();
        System.out.println("Value" +volume);
        Assert.assertEquals(volume, "100");
    }
    @Test(priority=3)
    public void minValueTest(){
        WebElement slider = driver.findElement(By.id("slider"));
        builder.clickAndHold(slider).moveByOffset(-75, 0).release().build().perform();
        WebElement val = driver.findElement(By.xpath("//span[@id='value']"));
        String volume= val.getText();
        System.out.println("Value" +volume);
        Assert.assertEquals(volume, "0");
    }
    @Test(priority=4)
    public void thirtyValueTest(){
        WebElement slider = driver.findElement(By.id("slider"));
        builder.clickAndHold(slider).moveByOffset(-30, 0).release().build().perform();
        WebElement val = driver.findElement(By.xpath("//span[@id='value']"));
        String volume= val.getText();
        System.out.println("Value" +volume);
        Assert.assertEquals(volume, "30");
    }
    @Test(priority=5)
    public void eightyValueTest(){
        WebElement slider = driver.findElement(By.id("slider"));
        builder.clickAndHold(slider).moveByOffset(44, 0).release().build().perform();
        WebElement val = driver.findElement(By.xpath("//span[@id='value']"));
        String volume= val.getText();
        System.out.println("Value" +volume);
        Assert.assertEquals(volume, "80");
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
