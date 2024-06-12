package SeleniumPackage;

public class Activity22 {
    public static void main(String[] args) {
       
        WebDriverManager.firefoxdriver().setup();
       
        WebDriver driver = new FirefoxDriver();
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        Actions builder = new Actions(driver);

        
        driver.get("https://v1.training-support.net/selenium/popups");
      
        System.out.println("Home page title: " + driver.getTitle());

        
        WebElement button = driver.findElement(By.className("orange"));
        
        builder.moveToElement(button).build().perform();
        
        String tooltipMessage = button.getAttribute("data-tooltip");
        System.out.println(tooltipMessage);

        button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

      
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
      
        username.sendKeys("admin");
        password.sendKeys("password");
        
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

      
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + message);

     
        driver.quit();
    }
}