package Project_LMS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Activity9 {
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

        WebElement Allcources= driver.findElement(By.xpath("//div[@class='main-navigation']/ul//li[@id='menu-item-1508']/a"));

        //Print the title of the page
        //Assert.assertEquals("My Account – Alchemy LMS",driver.getTitle());
        Allcources.click();
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals("All Courses – Alchemy LMS",driver.getTitle());
        WebElement Cources=driver.findElement(By.xpath("//div[@class='ld_course_grid col-sm-8 col-md-4 ']/article[@id='post-69']"));
        Cources.click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(5000);
        WebElement Expand=driver.findElement(By.xpath("//div[@class='ld-item-list-item-preview']//div[@class='ld-expand-button ld-button-alternate'][1]"));
        Expand.click();
        Thread.sleep(5000);
        WebElement Completion= driver.findElement(By.xpath("//span[@class='ld-lesson-list-progress'][1]"));
        Assert.assertEquals(Completion.getText(),"100% COMPLETE");




    }

    @AfterMethod
    public void ClosingOfDriver()
    {
      //  if(driver.getTitle().equals("All Courses – Alchemy LMS")) {
            driver.close();
        }
    }



