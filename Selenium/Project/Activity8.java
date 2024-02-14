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

public class Activity8 {
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
        WebElement ContactUs= driver.findElement(By.xpath("//div[@class='main-navigation']/ul//li[@id='menu-item-1506']/a"));

        //Print the title of the page
        //Assert.assertEquals("My Account – Alchemy LMS",driver.getTitle());
        ContactUs.click();
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals("Contact – Alchemy LMS",driver.getTitle());
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(5000);
        WebElement FullNameTxtbox=driver.findElement(By.xpath("//input[@id='wpforms-8-field_0']"));
        WebElement EmailTxtbox=driver.findElement(By.xpath("//input[@id='wpforms-8-field_1']"));
        WebElement SubjectTxtBox=driver.findElement(By.xpath("//input[@id='wpforms-8-field_3']"));
        WebElement CommentArea=driver.findElement(By.xpath("//textarea[@id='wpforms-8-field_2']"));
        WebElement SendMessage=driver.findElement(By.xpath("//button[@id='wpforms-submit-8']"));
        FullNameTxtbox.sendKeys("Anshul Gupta");
        EmailTxtbox.sendKeys("anshulgupya123@gmail.com");
        SubjectTxtBox.sendKeys("Testing");
        CommentArea.sendKeys("Hello Word");
        SendMessage.click();
        WebElement Message=driver.findElement(By.xpath("//div[contains(@class,'wpforms-confirmation-container wpforms-confirmation-scroll')]/p"));
        System.out.println("Message is:"+Message.getText());
        Assert.assertEquals(Message.getText(),"Thanks for contacting us! We will be in touch with you shortly.");




    }

    @AfterMethod
    public void ClosingOfDriver()
    {
        if(driver.getTitle().equals("Contact – Alchemy LMS")) {
            driver.close();
        }
    }

}
