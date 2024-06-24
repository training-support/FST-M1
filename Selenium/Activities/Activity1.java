import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) {

        // Create a new instance of the Firefox driver
        WebDriver driver = new ChromeDriver();

       driver.get("https://v1.training-support.net");
       System.out.println("Title og the page is: " + driver.getTitle());
       driver.findElement(By.id("about-link")).click();
       System.out.println("Title of new page is :" + driver.getTitle());
       driver.quit();
    }
}