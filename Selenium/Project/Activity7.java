package Project_LMS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity7 {
    WebDriver driver;

    @BeforeMethod
    public void InitializationOfDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }
    @Test
    public void exampleTestCase() throws Exception{

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement  Allcources= driver.findElement(By.xpath("//div[@class='main-navigation']/ul//li[@id='menu-item-1508']/a"));

        //Print the title of the page
        //Assert.assertEquals("My Account – Alchemy LMS",driver.getTitle());
        Allcources.click();
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals("All Courses – Alchemy LMS",driver.getTitle());
        List<WebElement> Cources=driver.findElements(By.xpath("//div[@class='ld_course_grid col-sm-8 col-md-4 ']"));
        System.out.println("Number of Cources :-"+Cources.size());



    }

    @AfterMethod
    public void ClosingOfDriver()
    {
        if(driver.getTitle().equals("All Courses – Alchemy LMS")) {
            driver.close();
        }
    }


}
