package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;
    Actions builder;
    @BeforeClass(alwaysRun = true)
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //OPen the Page
        driver.get("http://alchemy.hguy.co/orangehrm");
    }
    @Test(priority = 1)
    public void loginTest(){
        WebElement username= driver.findElement(By.id("txtUsername"));
        WebElement password=driver.findElement(By.id("txtPassword"));

        username.sendKeys("orange");
        password.sendKeys("orangepassword123");

        WebElement button= driver.findElement(By.cssSelector("#btnLogin"));
        button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_dashboard_index")));

        String pagename=driver.findElement(By.cssSelector("#menu_dashboard_index > b:nth-child(1)")).getText();
        System.out.println("Page Opened:"+pagename);
        Assert.assertEquals(pagename, "Dashboard");
    }
    @Test (priority = 2)
    public void myInfoOpenTest(){
        WebElement myInfo=driver.findElement(By.cssSelector("#menu_pim_viewMyDetails > b:nth-child(1)"));
        String pagename=myInfo.getText();
        myInfo.click();
        myInfo.click();
        System.out.println("Page Opened:"+pagename);

        driver.findElement(By.cssSelector("#sidenav > li:nth-child(3) > a:nth-child(1)")).click();
        //Get rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'hover')]/tbody/tr"));
        System.out.println("Table contents:");
        for(int i=1; i<=rows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]"));
            System.out.println("Row " + i + ": " + row.getText());
        }
        System.out.println("Phonenumbers:");
        for(int i=1; i<=rows.size(); i++) {
            WebElement cellValue2_2 = driver.findElement(By.xpath("//table[contains(@class, 'hover')]/tbody/tr["+i+"]/td[5]"));
            System.out.println(cellValue2_2.getText());
        }
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
