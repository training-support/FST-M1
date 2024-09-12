package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Initialize Firefox driver object
        driver = new FirefoxDriver();
        // Initialize wait object
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open browser
        driver.get("https://alchemy.hguy.co/jobs");
    }

    @DataProvider(name = "JobPost")
    public static Object[][] jobDetails() {
        return new Object[][] { { "abc123afc456@xyz.com", "Role", "Full Time","Description","EMail@email.com","Company"}};
    }
    @Test
    public void PostJobMenu() {
        driver.findElement(By.linkText("Post a Job")).click();
        String title= driver.getTitle();
        //System.out.println(title);

        //Assertion
       Assert.assertEquals(title,"Post a Job – Alchemy Jobs");

    }
    @Test (dataProvider = "JobPost",dependsOnMethods = "PostJobMenu")
    public void CreateJob(String email, String role,String type, String desc, String postEmail, String company) throws InterruptedException {
        WebElement WE_email = driver.findElement(By.id("create_account_email"));
        WebElement WE_role = driver.findElement(By.id("job_title"));
        WebElement WE_desc = driver.findElement(By.id("job_description_ifr"));
        WebElement WE_postemail = driver.findElement(By.id("application"));
        WebElement WE_company = driver.findElement(By.id("company_name"));
        WebElement WE_Preview = driver.findElement(By.xpath("//input[@value='Preview']"));
        WebElement WE_Submit = driver.findElement(By.id("job_preview_submit_button"));

        WE_email.sendKeys(email);
        WE_role.sendKeys(role);
        WE_desc.sendKeys(desc);
        WE_postemail.sendKeys(postEmail);
        WE_company.sendKeys(company);
        //Thread.sleep(1000);
        WE_Preview.click();
        wait(50000);
        WE_Submit.click();


    }
    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
