package Project_LMS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
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
    public void exampleTestCase() {
        // Check the title of the page
        Heading = driver.findElement(By.xpath("//h3[@class='uagb-ifb-title' and text()=' Actionable Training ']")).getText();

        //Print the title of the page
        System.out.println("Page title is: " + Heading);

        //Assertion for page title
        Assert.assertEquals("Actionable Training", Heading);

    }

    @AfterMethod
    public void ClosingOfDriver()
    {
        if(Heading.equals("Actionable Training")) {
            driver.close();
        }
    }


}
