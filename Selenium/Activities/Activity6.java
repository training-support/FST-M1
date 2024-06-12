package SeleniumPackage;

public class Activity6 {
    public static void main(String[] args) {
        
        WebDriverManager.firefoxdriver().setup();
       
        WebDriver driver = new FirefoxDriver();
       
        Actions builder = new Actions(driver);

        
        driver.get("https://v1.training-support.net/selenium/input-events");
        
        System.out.println("Home page title: " + driver.getTitle());

        builder.sendKeys("S").build().perform();
        
        builder.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        driver.close();
    }
}
