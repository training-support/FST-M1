package SeleniumPackage;

public class Activity16 {
    public static void main(String[] args) {
       
        WebDriverManager.firefoxdriver().setup();
       
        WebDriver driver = new FirefoxDriver();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
       
        System.out.println("Home page title: " + driver.getTitle());

        WebElement userName = driver.findElement(By.xpath("//input[contains(@class, '-username')]"));
        WebElement password = driver.findElement(By.xpath("//input[contains(@class, '-password')]"));
        WebElement confirmPassword = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following-sibling::input"));
        WebElement email = driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following-sibling::input"));

        userName.sendKeys("NewUser");
        password.sendKeys("Password");
        confirmPassword.sendKeys("Password");
        email.sendKeys("real_email@xyz.com");
        
        driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();

        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);

        driver.quit();
    }
}