import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity17 {
    public static void main(String[] args) {
        WebDriver driver =new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Home page title: " + driver.getTitle());

        // Find the dropdown
        WebElement dropdown = driver.findElement(By.id("single-select"));

        // Pass the WebElement to the Select object
        Select singleSelect = new Select(dropdown);

        // Select the second option using visible text
        singleSelect.selectByVisibleText("Option 2");
        // Print the selected option
        System.out.println("Second option: " + singleSelect.getFirstSelectedOption().getText());

        // Select the third option using index
        singleSelect.selectByIndex(3);
        // Print the selected option
        System.out.println("Third option: " + singleSelect.getFirstSelectedOption().getText());

        // Select the fourth option using value attribute
        singleSelect.selectByValue("4");
        // Print the selected option
        System.out.println("Fourth option: " + singleSelect.getFirstSelectedOption().getText());

        // Print all the options
        List<WebElement> allOptions = singleSelect.getOptions();
        System.out.println("Options in the dropdown: ");
        for(WebElement option : allOptions) {
            System.out.println(option.getText());
        }

        // Close the browser
        driver.quit();
    }
}
