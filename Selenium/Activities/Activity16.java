import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Activity16 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find the fields of the sign-up form
        WebElement userName = driver.findElement(By.xpath("//input[contains(@class, '-username')]"));
        WebElement password = driver.findElement(By.xpath("//input[contains(@class, '-password')]"));
        WebElement confirmPassword = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following-sibling::input"));
        WebElement email = driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following-sibling::input"));

        // Type credentials
        userName.sendKeys("Manu");
        password.sendKeys("Password");
        confirmPassword.sendKeys("Password");
        email.sendKeys("manu@gmail.com");

        // Click Sign Up
        driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();

        // Print login message
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);

        // Close the browser
        driver.quit();
    }
}
