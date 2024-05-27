package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/selects");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Select dropdown = new Select(driver.findElement(By.id("single-select")));
        dropdown.selectByVisibleText("Option 2");
        System.out.println(dropdown.getFirstSelectedOption().getText());
dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
dropdown.selectByValue("4");
        System.out.println(dropdown.getFirstSelectedOption().getText());
System.out.println("The Options are:");
for(WebElement option: dropdown.getOptions()) {
    System.out.println(option.getText());
}
}
}
