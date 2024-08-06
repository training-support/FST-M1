import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LMSProject_Activity2 {

    public  static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/lms");
        String HeaderText = driver.findElement(By.xpath("//h1[contains(@class,'title')]")).getText();
        System.out.println("heading of the webpage: " + HeaderText);

        if(HeaderText.equals("Learn from Industry Experts"))
            driver.close();



    }
}
