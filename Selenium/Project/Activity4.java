import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LMSProject_Activity4 {

    public  static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/lms");
        String secondPopularCourse = driver.findElement(By.xpath("(//h3[contains(@class,'entry-title')])[2]")).getText();


        if (secondPopularCourse.equals("Email Marketing Strategies")) {

            System.out.println(" title of the second most popular course matches with: " + secondPopularCourse);
            driver.close();
        }
    }
}

