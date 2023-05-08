package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class Activity4 {
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
    @Test (priority = 1)
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
    @Test(priority = 2)
    public void pimPageTest() throws InterruptedException {
        WebElement pim=driver.findElement(By.cssSelector("#menu_pim_viewPimModule > b:nth-child(1)"));
        String pagename=pim.getText();
        pim.click();
        pim.click();
        System.out.println("Page Opened:"+pagename);
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys("ABCTRTRBBV6");
        driver.findElement(By.id("lastName")).sendKeys("XYZ");
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        WebElement employee=driver.findElement(By.cssSelector("#empsearch_employee_name_empName"));
        employee.click();
        employee.clear();
        employee.sendKeys("ABCTRTRBBV6 XYZ");
        employee.sendKeys(Keys.SPACE);
        driver.findElement(By.id("empsearch_id")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("searchBtn"))).click();
        String check=driver.findElement(By.cssSelector("td.left:nth-child(3) > a:nth-child(1)")).getText();
        System.out.println("Searched Employee:"+check);
       Assert.assertEquals(check, "ABCTRTRBBV6");

    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        //driver.quit();
    }
}
