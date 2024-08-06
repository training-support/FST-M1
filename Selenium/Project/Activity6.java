import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LMSProject_Activity6 {
    public  static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/lms");

        driver.findElement(By.xpath("(//*[contains(@class,'main-header-bar-navigation')]//a)[5]")).click();

        String title = driver.getTitle();

        if (title.equals("My Account – Alchemy LMS")) {
            System.out.println(" title of the page matches with: " + title);

        }
        driver.findElement(By.xpath("//*[contains(@class,'ld-login')]")).click();

        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
        // Find the password field and enter the password
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
        // Find the login button and click it
        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
        String usernamever = driver.findElement(By.xpath("//*[contains(@class,'display-name')]")).getText();


        if (usernamever.equals("root")) {
            System.out.println(" user is successfully logged in as " + usernamever);
            driver.close();

        }



    }
}
