import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LMSProject_Activity9 {
    public  static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/lms");
        driver.findElement(By.xpath("(//*[contains(@class,'main-header-bar-navigation')]//a)[5]")).click();

        driver.findElement(By.xpath("//*[contains(@class,'ld-login')]")).click();

        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
        // Find the password field and enter the password
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
        // Find the login button and click it
        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();

        driver.findElement(By.xpath("(//*[contains(@class,'main-header-bar-navigation')]//a)[2]")).click();
        driver.findElement(By.xpath("(//*[contains(@class,'btn btn-primary')])[1]")).click();
        driver.findElement(By.xpath("(//*[@class='ld-item-title'])[1]")).click();
        String title = driver.getTitle();
        System.out.println("About page title: " + title);

        if(title.equals("Developing Strategy - Alchemy LMS"))
            driver.close();







    }
}
