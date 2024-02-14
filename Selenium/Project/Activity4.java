package Project_LMS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
    WebDriver driver;
    String Heading;
    @BeforeMethod
    public void InitializationOfDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }
    @Test
    public void exampleTestCase() throws Exception{
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(5000);

        Heading = driver.findElement(By.xpath("//div[@class='ld_course_grid_price free']//following-sibling::div[@class='caption']/h3[text()='Email Marketing Strategies']")).getText();

        //Print the title of the page
        System.out.println("Page title is: " + Heading);

        //Assertion for page title
        Assert.assertEquals("Email Marketing Strategies", Heading);

    }

    @AfterMethod
    public void ClosingOfDriver()
    {
        if(Heading.equals("Email Marketing Strategies")) {
            driver.close();
        }
    }

}
