
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Activity6  {
    public static void main (String[] args)throws Exception {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement jobmenu = driver.findElement(By.xpath("//*[@id=\"menu-item-24\"]/a"));
        jobmenu.click();
        WebElement jobheader = driver.findElement(By.xpath("//*[@id=\"post-7\"]/header/h1"));
        WebElement keyword = driver.findElement(By.xpath(" //*[@id=\"search_keywords\"]"));
        keyword.sendKeys("Banking");
        WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/form/div[1]/div[4]/input"));
        element.click();
        Thread.sleep(1000);
        WebElement ulElement = driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/ul"));
        System.out.println("Print the list name: " +ulElement);
         WebElement listItem = ulElement.findElement(By.xpath("./li[1]/a")); // get the 2nd list item
         listItem.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div/main/article/div/div/div/div[3]/input"))).click();

        driver.quit();
    }
}

