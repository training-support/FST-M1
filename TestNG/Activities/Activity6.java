package TestNGpgms;

public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;
 
    @BeforeClass
    public void beforeClass() {
       
        WebDriverManager.firefox().setup();
       
        driver = new FirefoxDriver();
       
        wait = new WebDriverWait(driver, 10);
        
        
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
    
    @Test
    @Parameters({"username", "password"})
    public void loginTestCase(String username, String password) {
       
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        
        
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        
       
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
       
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(loginMessage, "Welcome Back, admin");
    }
 
    @AfterClass
    public void afterClass() {
       
        driver.close();
    }
 
}