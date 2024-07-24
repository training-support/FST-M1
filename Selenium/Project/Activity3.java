import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement headerImage=driver.findElement(By.xpath("//*[@id=\"post-16\"]/header/div/img"));
        String headerurl= headerImage.getAttribute("src");
        System.out.println("header url is:" + headerurl);
        driver.quit();
    }

}
