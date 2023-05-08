package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity2 {
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
    public void urlTest(){
        //Verify url of link
        WebElement header= driver.findElement(By.cssSelector("#divLogo > img:nth-child(1)"));
        String link=header.getAttribute("src");
        System.out.println("URL of header image:" +link);
        Assert.assertEquals(link, "http://alchemy.hguy.co:8080/orangehrm/symfony/web/webres_5d69118beeec64.10301452/themes/default/images/login/logo.png");
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
