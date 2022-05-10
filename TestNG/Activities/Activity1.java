package Activities


import org.openqa.selenium.WebDriver;

public class Activity1 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://www.training-support.net");
    }

    @Test
    public void exampleTestCase() {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("Training Support", title);

        //Find the clickable link on the page and click it
        driver.findElement(By.id("about-link")).click();

        //Print title of new page
        System.out.println("New page title is: " + driver.getTitle());

        Assert.assertEquals(driver.getTitle(), "About Training Support");
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
