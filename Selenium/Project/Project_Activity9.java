import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //Include alwaysRun property on the @BeforeTest
    //to make sure the page opens
    //Include alwaysRun property on the @BeforeTest
    //to make sure the page opens
    @BeforeTest(alwaysRun = true)
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://alchemy.hguy.co/lms");
        driver.manage().window().minimize();
    }

    @Test
    //Navigate to a particular lesson and complete it.
    public void completeLession() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("My Account"))));
        driver.findElement(By.linkText("My Account")).click();
        // wait.until(ExpectedConditions.titleIs("My Account – Alchemy LMS"));
        System.out.println(driver.getTitle());
        Assert.assertEquals("My Account – Alchemy LMS", driver.getTitle());
        //  driver.findElement(By.className("login")).click();
        // driver.findElement(By.className("login-button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@class='ld-login ld-login ld-login-text ld-login-button ld-button']"))));
        WebElement login=driver.findElement(By.xpath("//a[@class='ld-login ld-login ld-login-text ld-login-button ld-button']"));

        login.click();
        System.out.println("We are now logging in... ");
        //  Alert alert=driver.switchTo().alert();
        //       String windowhandle= driver.getWindowHandle();
        //   driver.switchTo().window(windowhandle);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='wp-submit']"))));

        WebElement username=driver.findElement(By.xpath("//input[@id='user_login']"));
        //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS        );

        username.sendKeys("root");

        System.out.println("Entered username");

        WebElement password=driver.findElement(By.xpath("//input[@id='user_pass']"));
        // wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys("pa$$w0rd");
        System.out.println("Password Entered");
        //  driver.findElement(By.xpath("//input[@name='wp-submit']")).click();
        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath()))
        WebElement submit_btn=driver.findElement(By.xpath("//input[@name='wp-submit']"));
        if(submit_btn.isEnabled()){
            submit_btn.click();
        }
        else {
            System.out.println(("button is not enabled"));
        }


         /*   driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();*/
        //  driver.findElement(By.xpath("//a[contains(text(),'Howdy')]")).isDisplayed();
        String welcomeMsg=driver.findElement(By.xpath("//p[@class='uagb-ifb-desc']")).getText();
        System.out.println("Login message:"+welcomeMsg);

        driver.findElement(By.linkText("All Courses")).click();
        //List<WebElement> courses=driver.findElements(By.xpath("//h3[@class='entry-title']"));

        driver.findElement(By.linkText("See more...")).click();
        WebElement el= (driver.findElement(By.xpath("//h1[@class='entry-title']")));
        // driver.findElement(By.xpath("(//img[@class='attachment-course-thumb size-course-thumb wp-post-image'])[1]")).click();
        wait.until(ExpectedConditions.visibilityOf(el));
        driver.findElement(By.xpath("//div[@class='ld-item-title']")).click();
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS        );
        System.out.println("We are on "+driver.getTitle()+"page");
        Assert.assertEquals("Developing Strategy – Alchemy LMS", driver.getTitle());


    }

    @AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.quit();

    }
}
