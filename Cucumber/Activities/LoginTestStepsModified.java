package CucumberPgms;


public class LoginTestStepsModified {
    WebDriver driver;
    WebDriverWait wait;
    
    @Given("^User is on Login page$")
    public void loginPage() {
        //Setup instances
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        //Open browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    
    @When("^User enters username and password$")
    public void enterCredentials() {
        //Enter username
        driver.findElement(By.id("username")).sendKeys("admin");
        //Enter password
        driver.findElement(By.id("password")).sendKeys("password");
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
 
    @When("^User enters {string} and {string}$")
    public void user_enters_and(String username, String password) throws Throwable {
        //Enter username from Feature file
        driver.findElement(By.id("username")).sendKeys(username);
        //Enter password from Feature file
        driver.findElement(By.id("password")).sendKeys(password);
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    
    @Then("^Read the page title and confirmation message$")
    public void readTitleAndHeading() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        
        //Read the page title and heading
        String pageTitle = driver.getTitle();
        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();
        
        //Print the page title and heading
        System.out.println("Page title is: " + pageTitle);
        System.out.println("Login message is: " + confirmMessage);
        
        if(confirmMessage.contains("admin")) {
            Assert.assertEquals(confirmMessage, "Welcome Back, admin");
        } else {
            Assert.assertEquals(confirmMessage, "Invalid Credentials");
        }
    }
    
    @And("^Close the Browser$")
    public void closeBrowser() {
        //Close browser
        driver.close();
    }
 
}
ACTIVITY 5
ActivitiesRunner.java Solution

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@activity5"
)
 
public class ActivitiesRunner {}
ACTIVITY 6
Now we add the code to add the test report in an HTML file. The plugin option should be modified to push the test result to html with the .html file stored in a folder named test-reports.

@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@SmokeTest",
    plugin = {"html: test-reports"},
    monochrome = true
)
The plugin option here writes the test result to a index.html file in a folder named test-reports.

ACTIVITY 6
Example .xml file using junit:


ACTIVITY 6
ActivitesRunner.java Solution for pretty reports. This will print in the console.

Solutions

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@SimpleAlert",
    plugin = {"pretty"},
    monochrome = true
)

public class ActivitiesRunner {
    //This is intentionally blank
}
THANK YOU
24 . 5



