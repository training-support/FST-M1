package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/selects");

        //Print title
        System.out.println("title:" + driver.getTitle());


        WebElement dropdown = driver.findElement(By.id("multi-select"));
        Select select = new Select(dropdown);
        WebElement chosen = driver.findElement(By.id("multi-value"));

        if (select.isMultiple()) {
            select.selectByVisibleText("Javascript");
            System.out.println(chosen.getText());

            select.selectByValue("node");
            System.out.println(chosen.getText());

            select.selectByIndex(4);
            select.selectByIndex(5);
            select.selectByIndex(6);
            System.out.println(chosen.getText());

            select.deselectByValue("node");
            System.out.println(chosen.getText());

            select.deselectByIndex(7);
            System.out.println(chosen.getText());

            List<WebElement> selectedOptions = select.getAllSelectedOptions();
            //Print all selected options
            for (WebElement selectedOption : selectedOptions) {
                System.out.println("Selected option: " + selectedOption.getText());
            }

            select.deselectAll();
            System.out.println(chosen.getText());
        }
        driver.quit();
    }
}
