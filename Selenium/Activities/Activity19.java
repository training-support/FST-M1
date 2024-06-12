package SeleniumPackage;

public class Activity19 {
    public static void main(String[] args) {
       
        WebDriverManager.firefoxdriver().setup();
       
        WebDriver driver = new FirefoxDriver();
        
       
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        
        System.out.println("Home page title: " + driver.getTitle());

       
        driver.findElement(By.id("confirm")).click();

        
        Alert confirmAlert = driver.switchTo().alert();

        
        String alertText = confirmAlert.getText();
        System.out.println("Text in alert: " + alertText);

        
        confirmAlert.accept();

        
        driver.quit();
    }
}