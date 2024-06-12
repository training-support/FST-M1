package SeleniumPackage;

public class Activity13 {
    public static void main(String[] args) {
       
        WebDriverManager.firefoxdriver().setup();
        
        WebDriver driver = new FirefoxDriver();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://v1.training-support.net/selenium/tables");
       
        System.out.println("Home page title: " + driver.getTitle());

        List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[1]/td"));
        System.out.println("Number of columns: " + cols.size());
        
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr"));
        System.out.println("Number of rows: " + rows.size());

   
        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[3]/td"));
        System.out.println("Third row cell values: ");
        for(WebElement cell : thirdRow) {
            System.out.println(cell.getText());
        }

        WebElement cellValue = driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second cell value: " + cellValue.getText());

        driver.close();
    }
}