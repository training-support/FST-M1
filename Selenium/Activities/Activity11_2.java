package SeleniumActivities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");

        //Click the button to open a confirm alert
        driver.findElement(By.cssSelector("button#confirm")).click();

        //Switch to alert window
        Alert confirmAlert = driver.switchTo().alert();

        //Get text in the alert box and print it
        String alertText = confirmAlert.getText();
        System.out.println("Alert text is: " + alertText);

        //Close the alert with OK
        Thread.sleep(2000);
        confirmAlert.accept();
        System.out.println("Alert is accepted");
        
        Thread.sleep(2000);
        
        //Close the alert browser with Cancel
        driver.findElement(By.cssSelector("button#confirm")).click();
        Alert confirmAlert1 = driver.switchTo().alert();
        System.out.println("Alert text is: "+confirmAlert1.getText());
        Thread.sleep(2000);
        confirmAlert1.dismiss();
        System.out.println("Alert is dismissed");

        //Close the Browser
        driver.close();
    }
}
