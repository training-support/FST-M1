import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity7 {
    public static void main(String[] args) throws Exception {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");

        WebElement jobpost= driver.findElement(By.xpath("//*[@id=\"menu-item-26\"]/a"));
        jobpost.click();
        WebElement jobtitle= driver.findElement(By.name("job_title"));
        jobtitle.sendKeys("Test Engg");
        WebElement youremail=driver.findElement(By.name("create_account_email"));
        youremail.sendKeys("Abc@gmail.com");
        WebElement location=driver.findElement(By.xpath("//*[@id=\"job_location\"]"));
        location.sendKeys("Banglore");
        WebElement jobtype= driver.findElement(By.id("job_type"));
        Select select = new Select(jobtype);
        select.selectByVisibleText("Internship");

        WebElement description=driver.findElement(By.xpath("/html/body"));
        description.click();
        description.sendKeys("Looking for job");
        driver.quit();
    }
}




