import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8 {
    public static void main(String[] args) throws Exception {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");

        WebElement username= driver.findElement(By.id("user_login"));
        username.sendKeys("yogitabhosale");

        WebElement password=driver.findElement(By.id("user_pass"));
        password.sendKeys("Alpha@100");

        WebElement login=driver.findElement(By.id("wp-submit"));
        login.click();
        driver.quit();
    }
}
