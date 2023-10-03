package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");

        System.out.println("Title of the page: " + driver.getTitle());

        String textThird = driver.findElement(By.xpath("//*[@id=\"third-header\"]")).getText();
        System.out.println("Text in 3rd Header: " +textThird);

        String colorFifth = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5")).getCssValue("color");
        System.out.println("Color in 5th Header: " +colorFifth);

        String classViolet = driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
        System.out.println("Classes of Violet button:" +classViolet);

        String textGrey = driver.findElement(By.xpath("//button[text()='Grey']")).getText();
        System.out.println("Text of grey button: " +textGrey);

        driver.close();
    }
}
