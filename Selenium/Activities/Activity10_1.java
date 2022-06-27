package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);
        driver.get("https://www.training-support.net/selenium/input-events");
        //Find the cube
        WebElement cube = driver.findElement(By.id("wrapD3Cube"));

        //Left click
        WebElement beforeCubeVal = driver.findElement(By.className("active"));
        System.out.println("Left Click: " + beforeCubeVal.getText());
        Thread.sleep(2000);
        actions.click(cube);
        Thread.sleep(2000);
        WebElement cubeVal = driver.findElement(By.className("active"));
        System.out.println("Left Click: " + cubeVal.getText());

        //Double click
        actions.doubleClick(cube).perform();
        Thread.sleep(2000);
        cubeVal = driver.findElement(By.className("active"));
        System.out.println("Double Click: " + cubeVal.getText());
        
        //Right click        
        actions.contextClick(cube).perform();
        Thread.sleep(2000);
        cubeVal = driver.findElement(By.className("active"));
        System.out.println("Right Click: " + cubeVal.getText());

        //Close browser
        driver.close();
    }
}
