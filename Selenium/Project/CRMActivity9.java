package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CRMActivity9 {
    public static  void main  (String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("http://alchemy.hguy.co/crm");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

        WebElement salesMenu = driver.findElement(By.xpath("//a[text()='Sales']"));

        //Actions
        Actions actions = new Actions(driver);


        actions.moveToElement(salesMenu);


        WebElement subMenu = driver.findElement(By.xpath("//a[text()='Leads']"));

        actions.moveToElement(subMenu);
        actions.click().build().perform();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Additional Details']")));

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


        List<WebElement> name = driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr/td[3]"));
        if (name.size() == 10) {
            for (int i = 0; i < name.size(); i++) {
                System.out.println(name.get(i).getText());
            }
        } else {
            System.out.println("Size is not 10");
        }

        List<WebElement> user = driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr/td[8]"));
        if (name.size() == 10) {
            for (int i = 0; i < user.size(); i++) {
                System.out.println(user.get(i).getText());
            }
        } else {
            System.out.println("Size is not 10");
        }

        driver.close();
    }
}
