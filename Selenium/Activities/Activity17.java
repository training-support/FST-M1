package SeleniumPackage;

public class Activity17 {
    public static void main(String[] args) {
       
        WebDriverManager.firefoxdriver().setup();
        
        WebDriver driver = new FirefoxDriver();
      
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      
        driver.get("https://v1.training-support.net/selenium/selects");
      
        System.out.println("Home page title: " + driver.getTitle());

     
        WebElement dropdown = driver.findElement(By.id("single-select"));

       
        Select singleSelect = new Select(dropdown);

       
        singleSelect.selectByVisibleText("Option 2");
        
        System.out.println("Second option: " + singleSelect.getFirstSelectedOption().getText());

      
        singleSelect.selectByIndex(3);
      
        System.out.println("Third option: " + singleSelect.getFirstSelectedOption().getText());

        
        singleSelect.selectByValue("4");
        
        System.out.println("Fourth option: " + singleSelect.getFirstSelectedOption().getText());

      
        List<WebElement> allOptions = singleSelect.getOptions();
        System.out.println("Options in the dropdown: ");
        for(WebElement option : allOptions) {
            System.out.println(option.getText());
        }

        driver.quit();
    }
}