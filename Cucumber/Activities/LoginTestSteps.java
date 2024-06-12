package CucumberPgms;


public class LoginTestSteps {
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

    //Assertion
    Assert.assertEquals(confirmMessage, "Welcome Back, admin");
}

@And("^Close the Browser$")
public void closeBrowser() {
    //Close browser
    driver.close();
}

}