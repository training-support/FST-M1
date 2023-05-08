package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
public class Activity5 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        //OPen the Page
        driver.get(" https://www.training-support.net/selenium/target-practice");
    }

    @Test (groups = "HeaderTests")
    public void titleTest(){
        //Verify Page title
        Assert.assertEquals(driver.getTitle(), "Target Practice");
    }
    @Test (dependsOnMethods = {"titleTest"},groups = "HeaderTests")
    public void thirdHeaderTest(){
        WebElement header3 = driver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(header3.getText(), "Third header");
    }
    @Test (dependsOnMethods = {"titleTest"},groups = "HeaderTests")
    public void FifthHeaderTest(){
        WebElement header5 = driver.findElement(By.cssSelector("h3#third-header"));
        Assert.assertEquals(header5.getCssValue("color"), "rgb(251, 189, 8)");
    }
    @Test (dependsOnMethods = {"titleTest"},groups = "ButtonTests")
    public void firstButton(){
        WebElement button2 = driver.findElement(By.cssSelector("button.brown"));
        Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");
    }
    @Test(dependsOnMethods = {"titleTest"},groups = "ButtonTests")
    public void oliveButton(){
        WebElement button1 = driver.findElement(By.cssSelector("button.olive"));
        Assert.assertEquals(button1.getText(), "Olive");
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}

/*
<?xml version="1.0" encoding="UTF-8"?>
<suite name="ExampleSuite" >
    <test name="SuiteTests" >
        <groups>
            <run>
                <include name="HeaderTests" />
                <include name="ButtonTests" />
            </run>
        </groups>
        <classes>
            <class name="activities.Activity5"/>
        </classes>
    </test>
</suite>
 */
