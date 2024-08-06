import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LMSProject_Activity3 {
    public  static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/lms");
        String firstInfoBox = driver.findElement(By.xpath("//h3[contains(@class,'title')]")).getText();


        if(firstInfoBox.equals("Actionable Training")){

            System.out.println("title of the first info box matches with: " + firstInfoBox);
            driver.close();
        }




    }
}
