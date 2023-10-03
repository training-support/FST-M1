package CRM_Project;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity2 {
    public static void main (String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("http://alchemy.hguy.co/crm");
        // System.out.println("logo name: "+driver.findElement(By.className("companylogo")).getText());
        System.out.println("image url :"+driver.findElement(By.cssSelector("img")).getAttribute("src"));
        //  System.out.println("logo name: "+driver.findElement(By.xpath("//div[@class='companylogo']")).getText());
        driver.close();
    }
}
