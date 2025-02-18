package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();

        Reporter.log("Starting Test |");
        // Open browser
        driver.get("https://training-support.net/webelements/alerts");
        Reporter.log("Opened Browser |");

        // Print title of page
        Reporter.log("Page title is " + driver.getTitle() + " |");
    }

    @BeforeMethod
    public void beforeMethod() {
        Reporter.log("Test Case Setup started |");
        driver.switchTo().defaultContent();
    }

    @Test(priority = 1)
    public void simpleAlertTestCase() {
        Reporter.log("simpleAlertTestCase() started |");
        // Click the button to open a simple alert
        driver.findElement(By.id("simple")).click();
        Reporter.log("Simple Alert opened |");

        // Switch to alert window
        Alert simpleAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");

        // Get text in the alert box and print it
        String alertText = simpleAlert.getText();
        Reporter.log("Alert text is: " + alertText + " |");

        // Assertion
        Assert.assertEquals("You've just triggered a simple alert!", alertText);

        simpleAlert.accept();
        Reporter.log("Alert closed");

        Reporter.log("Test case ended |");
    }

    @Test(priority = 2)
    public void confirmAlertTestCase() {
        Reporter.log("confirmAlertTestCase() started |");
        // Click the button to open a simple alert
        driver.findElement(By.id("confirmation")).click();
        Reporter.log("Confirm Alert opened |");

        // Switch to alert window
        Alert confirmAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");

        // Get text in the alert box and print it
        String alertText = confirmAlert.getText();
        Reporter.log("Alert text is: " + alertText + " |");

        // Assertion
        Assert.assertEquals("You've just triggered a confirmation alert!", alertText);

        confirmAlert.accept();
        Reporter.log("Alert closed |");

        Reporter.log("Test case ended |");
    }

    @Test(priority = 3)
    public void promptAlertTestCase() {
        Reporter.log("promptAlertTestCase() started |");
        // Click the button to open a simple alert
        driver.findElement(By.id("prompt")).click();
        Reporter.log("Prompt Alert opened |");

        // Switch to alert window
        Alert promptAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");

        // Get text in the alert box and print it
        String alertText = promptAlert.getText();
        Reporter.log("Alert text is: " + alertText + " |");

        // Assertion
        Assert.assertEquals("I'm a Prompt! Type something into me!", alertText);
        // Type some text into the prompt
        promptAlert.sendKeys("Awesome!");
        Reporter.log("Text entered in prompt alert |");
        // Close the prompt
        promptAlert.accept();
        Reporter.log("Alert closed |");

        Reporter.log("Test case ended |");
    }

    @AfterClass
    public void tearDown() {
        Reporter.log("Ending Test |");
        // Close the driver
        driver.close();
    }
}