import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
      WebElement jobmenu = driver.findElement(By.xpath("//*[@id=\"menu-item-24\"]/a"));
        jobmenu.click();
      WebElement jobheader=driver.findElement(By.xpath("//*[@id=\"post-7\"]/header/h1"));
       String jobhead=jobheader.getText();
        System.out.println(" heading is:" + jobhead);
        if(jobhead.equals("Jobs")) {
            driver.quit();
        }
        }
    }
