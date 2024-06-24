import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Activity2 {
    public static void main(String[] args) {

        // Create a new instance of the Firefox driver
        WebDriver driver = new ChromeDriver();

        // Open the page
        driver.get("https://v1.training-support.net/selenium/login-form");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());
        driver.findElement(By.name("Username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String message = driver.findElement(By.xpath("//div[text()='Welcome Back, admin']")).getText();
        System.out.println("After login " +message);
        driver.quit();

    }
}