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
import java.util.concurrent.TimeUnit;

public class CRMActivity7 {

    public static  void main  (String[] args)
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("http://alchemy.hguy.co/crm");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();


        WebElement salesMenu = driver.findElement(By.xpath("//a[text()='Sales']"));

        // Instantiating Actions class
        Actions actions = new Actions(driver);

        // Hovering on main menu
        actions.moveToElement(salesMenu);

        // Locating the element from Sub Menu
        WebElement subMenu = driver.findElement(By.xpath("//a[text()='Leads']"));

        // To mouseover on sub menu & click
        actions.moveToElement(subMenu);
        actions.click().build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Additional Details']")));
        WebElement Addit1 = driver.findElement(By.xpath("(//*[@title='Additional Details'])[1]"));
        Addit1.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='phone']")));
        WebElement ele = driver.findElement(By.xpath("//span[@class='phone']"));
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        System.out.println(ele.getText());
        driver.close();


    }
}
