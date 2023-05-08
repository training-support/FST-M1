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

public class Activity5 {
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
    @Test
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
    public void myInfoTest(){
        WebElement myInfo=driver.findElement(By.cssSelector("#menu_pim_viewMyDetails > b:nth-child(1)"));
        String pagename=myInfo.getText();
        myInfo.click();
        myInfo.click();
        System.out.println("Page Opened:"+pagename);
        driver.findElement(By.cssSelector("#btnSave")).click();
        WebElement name=driver.findElement(By.id("personal_txtEmpFirstName"));
        name.clear();
        name.sendKeys("TestEmployee1");
        WebElement lastName=driver.findElement(By.id("personal_txtEmpLastName"));
        lastName.clear();
        lastName.sendKeys("TEST123");
        WebElement gender=driver.findElement(By.id("personal_optGender_1"));
        if(gender.isSelected())
            driver.findElement(By.id("personal_optGender_2")).click();
        else
            gender.click();
        WebElement dropdown = driver.findElement(By.id("personal_cmbNation"));
        Select list = new Select(dropdown);
        list.selectByIndex(35);
        driver.findElement(By.id("btnSave")).click();
        WebElement name1=driver.findElement(By.id("personal_txtEmpFirstName"));
        Assert.assertEquals(name1.getAttribute("value"), "TestEmployee1");
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
