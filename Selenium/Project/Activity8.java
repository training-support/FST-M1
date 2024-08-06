import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LMSProject_Activity8 {

    public  static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/lms");

        driver.findElement(By.xpath("(//*[contains(@class,'main-header-bar-navigation')]//a)[4]")).click();


        driver.findElement(By.xpath("(//input[contains(@class,'wpforms-field-large wpforms-field-required')])[1]")).sendKeys("umateja");
        driver.findElement(By.xpath("(//input[contains(@id,'wpforms-8-field')])//following::*[contains(@type,'email')]")).sendKeys("umateja.marni@gmail.com");

        driver.findElement(By.xpath("//*[contains(@class,'wpforms-field-medium wpforms-field-required')]")).sendKeys("adding comment");

        driver.findElement(By.xpath("//*[@class='wpforms-submit ']")).click();
        String confirmation_message = driver.findElement(By.xpath("//*[contains(@id,'wpforms-confirmation')]")).getText();


        System.out.println("confirmation message " +confirmation_message);

        driver.close();

    }
}
