package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1  {

    public static void main(String[] args) {

        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //And now use this to visit the website
        driver.get("https://www.training-support.net");

        //Check the title of the page
        String title = driver.getTitle();
        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Find the "Get Started!" link and click it
        driver.findElement(By.xpath("/html/body/div/div/div/a")).click();

        //Print title of new page
        System.out.println("Heading is: " + driver.getTitle());

        //Close the browser
        driver.close();

    }

}