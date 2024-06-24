import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Activity6 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // Create the Actions object
        Actions builder = new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/input-events");
        System.out.println("Home page title: " + driver.getTitle());

        // Press the key
        builder.sendKeys("M").build().perform();
        // Press CTRL+A and CTRL+C
        builder.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        // Close the browser
        driver.close();
    }
}
