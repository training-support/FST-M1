package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {

    WebDriver driver;
    @Test
    public void ReadMenuItem(){
        //Select s = new Select(driver.findElement(By.xpath("//a[@id='moduleTab_9_Leads']")));
        WebElement sales =driver.findElement(By.xpath("//a[@id='grouptab_0']"));
        Actions builder = new Actions(driver);
        Action actionsToPerform = builder.moveToElement(sales).click()

                .build();
        actionsToPerform.perform();
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/span[2]/ul/li[5]/a")).click();

        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[10]/span/span"))).click();

        String phoneno=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='bootstrap-container']/div[@id='content']/div[7]/div[2]/span"))).getText();

        System.out.println("phone no of lead1 is "+phoneno);
    }

    @BeforeMethod
    public void setup(){

        //Create a new instance of the Firefox driver
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/crm/");

        //Login
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
    }

    @AfterMethod

    public void tearDown()
    {

        driver.close();
    }
}
