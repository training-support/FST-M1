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

public class CRMActivity8 {
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
        WebElement subMenu = driver.findElement(By.xpath("//a[text()='Accounts']"));

        actions.moveToElement(subMenu);
        actions.click().build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='list view table-responsive']//tbody//tr")));

        // Get all the table row elements from the table
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@class='list view table-responsive']//tbody//tr[@class='oddListRowS1']"));

        // And iterate over them and get all the cells
        for (int i = 0; i < allRows.size(); i++) {
            if (i == 5) {
                break;
            }

            List<WebElement> cells = driver.findElements(By.xpath("//table[@class='list view table-responsive']//tbody//tr[@class='oddListRowS1']//td[3]"));
            // Print the contents of each cell
            System.out.println(cells.get(i).getText());
        }
        driver.close();

    }
}
