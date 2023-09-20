package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CRMActivity1 {
    public static void main(String[] args)
    {
        //System.setProperty("webdriver.chrome.driver", .BROWSER_LOGFILE, "/dev/null");
        //System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        driver.get("http://alchemy.hguy.co/crm");

        //getting the title of the webpage

        String title = driver.getTitle();
        //Checking whether it is matching to the suiteCRM or not
        System.out.println(title);

        if(title.contains("SuiteCRM"))
            System.out.println("Home page title is matching:" +title);
        else
           System.out.println("Home page title is not matching");

        driver.close();



    }

}
