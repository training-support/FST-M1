import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity1 {
    WebDriver driver;
    @Test
    public void activity1Testcase() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        System.out.println("Title of the page : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        driver.quit();
    }
}