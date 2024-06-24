import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Activity3 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/login-form");
        System.out.println("Home page title: " + driver.getTitle());

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String message = driver.findElement(By.xpath("//input[@id='action-confirmation']")).getText();
        System.out.println("Login message: " + message);

       // driver.quit();

    }
}
