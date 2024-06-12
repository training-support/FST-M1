package SeleniumPackage;

public class Activity20 {
    public static void main(String[] args) {
       
        WebDriverManager.firefoxdriver().setup();
       
        WebDriver driver = new FirefoxDriver();
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        
        System.out.println("Home page title: " + driver.getTitle());

       
        driver.findElement(By.id("prompt")).click();

        
        Alert promtAlert = driver.switchTo().alert();

        
        String alertText = promtAlert.getText();
        System.out.println("Text in alert: " + alertText);
      
        promtAlert.sendKeys("Awesome!");

       
        promtAlert.accept();

        
        driver.quit();
    }
}
