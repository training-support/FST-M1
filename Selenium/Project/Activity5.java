import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LMSProject_Activity5 {
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
            driver.close();
        }

    }
}
