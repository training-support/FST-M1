package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");

        //Print title
        System.out.println(driver.getTitle());

        WebElement check=driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/input"));
        if (check.isSelected())
            System.out.println("Checkbox selected");
        else
            System.out.println("Checkbox not selected");

        check.click();
        Thread.sleep(5000);

        if (check.isSelected())
            System.out.println("Checkbox selected");
        else
            System.out.println("Checkbox not selected");

        driver.quit();
    }
}
