package SeleniumPackage;

public class Activity10 {
    public static void main(String[] args) {
       
        WebDriverManager.firefoxdriver().setup();
      
        WebDriver driver = new FirefoxDriver();
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
       
        System.out.println("Home page title: " + driver.getTitle());

        WebElement checkbox = driver.findElement(By.className("willDisappear"));
       
        WebElement checkboxToggle = driver.findElement(By.id("toggleCheckbox"));
        checkboxToggle.click();
       
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("willDisappear")));
        System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());
       
        checkboxToggle.click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());
        
        driver.findElement(By.xpath("//input[@class='willDisappear']")).click();

        driver.close();
    }
}
