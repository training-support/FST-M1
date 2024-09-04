package FSTTestNG.Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity1 {

        static WebDriver driver;

        @BeforeClass
        public static void beforeMethod() {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get("https://v1.training-support.net");
        }

        @Test
        public void exampleTestCase() {
            String title = driver.getTitle();
            System.out.println("Page title is: " + title);
            Assert.assertEquals("Training Support", title);
            driver.findElement(By.id("about-link")).click();
            System.out.println("New page title is: " + driver.getTitle());
            Assert.assertEquals(driver.getTitle(), "About Training Support");
        }

        @AfterClass
        public static void afterMethod() {
           driver.quit();
        }

    }

