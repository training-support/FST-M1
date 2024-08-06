import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LMSProject_Activity1 {


    public  static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/lms");

        String title = driver.getTitle();
        System.out.println("About page title: " + title);

        if(title.equals("Alchemy LMS – An LMS Application"))
            driver.close();

    }
}
