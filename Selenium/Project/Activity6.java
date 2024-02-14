package Project_LMS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 {
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
        WebElement MyAccount = driver.findElement(By.xpath("//div[@class='main-navigation']/ul//li[@id='menu-item-1507']/a"));

        //Print the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        MyAccount.click();

        //Assertion for page title
        System.out.println("Page title is: " + driver.getTitle());

        Assert.assertEquals("My Account – Alchemy LMS",driver.getTitle());
        WebElement loginBtn= driver.findElement(By.xpath("//a[@class='ld-login ld-login ld-login-text ld-login-button ld-button']"));
        loginBtn.click();
        WebElement usernameTxtbox=driver.findElement(By.id("user_login"));
        WebElement passwordTxtbox=driver.findElement(By.id("user_pass"));
        WebElement SubmitBtn=driver.findElement(By.id("wp-submit"));


       // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("user_login")));
        usernameTxtbox.sendKeys("root");
        passwordTxtbox.sendKeys("pa$$w0rd");
        SubmitBtn.click();
        Assert.assertEquals("My Account",driver.findElement(By.tagName("h1")).getText());




    }

    @AfterMethod
    public void ClosingOfDriver()
    {
        if(driver.getTitle().equals("My Account – Alchemy LMS")) {
            driver.close();
        }
    }


}
