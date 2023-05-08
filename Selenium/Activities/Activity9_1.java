package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity9_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/selects");

        //Print title
        System.out.println("title:" + driver.getTitle());

        WebElement dropdown = driver.findElement(By.id("single-select"));
        Select select = new Select(dropdown);
        WebElement chosen = driver.findElement(By.id("single-value"));

        select.selectByVisibleText("Option 2");
        System.out.println(chosen.getText());
        select.selectByIndex(3);
        System.out.println(chosen.getText());
        select.selectByValue("4");
        System.out.println(chosen.getText());

        List<WebElement> options = select.getOptions();
        for(WebElement option : options) {
            System.out.println("Option: " + option.getText());
        }

        driver.quit();
    }
}
