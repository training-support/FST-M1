package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity14 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println("Title of the Page:  " + driver.getTitle());
        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        System.out.println("Number of columns: " + cols.size());
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        System.out.println("Number of rows: " + rows.size());
        WebElement cellValue = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second cell value: " + cellValue.getText());
        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th")).click();
        cellValue = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second cell value: " + cellValue.getText());
        List<WebElement> footer = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        System.out.println("Cell values of the footer: ");
        for(WebElement cell : footer) {
            System.out.println(cell.getText());
        }
        driver.quit();
    }
}
