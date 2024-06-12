package SeleniumPackage;

public class Activity11 {
    public static void main(String[] args) {
        
        WebDriverManager.firefoxdriver().setup();
       
        WebDriver driver = new FirefoxDriver();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        
        System.out.println("Home page title: " + driver.getTitle());

        WebElement checkbox = driver.findElement(By.name("toggled"));
        checkbox.click();
        System.out.println("Checkbox is selected: " + checkbox.isSelected());
       
        checkbox.click();
        System.out.println("Checkbox is selected: " + checkbox.isSelected());

        driver.close();
    }
}
