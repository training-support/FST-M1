import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/input-events");
        System.out.println("Title of the page :" + driver.getTitle());

        // Perform left click
        builder.click().pause(1000).build().perform();

        String frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);

        // Perform left click
        builder.doubleClick().pause(1000).build().perform();
        // Print the front side text
        frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);

        // Perform left click
        builder.contextClick().pause(1000).build().perform();
        // Print the front side text
        frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);

        // Close the browser
        driver.quit();
    }
}
