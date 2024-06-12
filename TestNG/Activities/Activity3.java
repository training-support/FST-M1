package TestNGpgms;

public class Activity3 {
    WebDriver driver;
 
    @BeforeClass
    public void beforeClass() {
       
        WebDriverManager.firefox().setup();
        driver = new FirefoxDriver();
 
        
        driver.get("https://v1.training-support.net/selenium/login-form");
    }
 
    @Test
    public void loginTest() {
        
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        
       
        username.sendKeys("admin");
        password.sendKeys("password");
        
        
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        
       
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals("Welcome Back, admin", loginMessage);
    }
 
    @AfterClass
    public void afterClass() {
       
        driver.close();
    }
}