package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity8 {
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
    public void applyLeaveTest(){
        WebElement leave=driver.findElement(By.xpath("//span[contains(text(), 'Apply Leave')]"));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@id, 'menu_leave_applyLeave')]")));
        leave.click();
        leave.click();
        WebElement dropdown= driver.findElement(By.id("applyleave_txtLeaveType"));
        Select select=new Select(dropdown);
        select.selectByIndex(1);
        WebElement fromDt= driver.findElement(By.id("applyleave_txtFromDate"));
        fromDt.clear();
        fromDt.sendKeys("2023-04-17");
        WebElement toDt= driver.findElement(By.id("applyleave_txtToDate"));
        toDt.clear();
        toDt.sendKeys("2023-04-21");
        driver.findElement(By.id("applyBtn")).click();
        driver.findElement(By.id("applyBtn")).click();

        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        WebElement status=driver.findElement(By.xpath("//a[contains(text(), 'Pending Approval(5.00)')]"));
        System.out.println(status.getText());
        Assert.assertEquals(status.getText(),"Pending Approval(5.00)");
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
