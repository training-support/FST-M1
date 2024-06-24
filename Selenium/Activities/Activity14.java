import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
public class Activity14 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println("Title of the page" + driver.getTitle());

        // Print the number of columns
        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        System.out.println("N. of columns" + cols.size());

        // Print the number of rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        System.out.println(" No. of rows " + rows.size());

        // Print the cell value of the second row and second column
        WebElement cellValue = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second cell value: " + cellValue.getText());

        // Sort the table
        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th")).click();

        // Print the cell value of the second row and second column again
        cellValue = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second cell value: " + cellValue.getText());

        // Print the cell values of the footer
        List<WebElement> footer = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        System.out.println("Cell values of the footer: ");
        for(WebElement cell : footer) {
            System.out.println(cell.getText());
        }

        // Close the browser
        driver.quit();

    }
}
