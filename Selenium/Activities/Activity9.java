package SeleniumPackage;

public class Activity9 {
    public static void main(String[] args) {
      
        WebDriverManager.firefoxdriver().setup();
       
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       
        driver.get("https://v1.training-support.net/selenium/ajax");

        driver.findElement(By.cssSelector("button.violet")).click();
       
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
       
        String text = driver.findElement(By.tagName("h1")).getText();
        System.out.println(text);

        WebElement delayedText = driver.findElement(By.tagName("h3"));
        System.out.println(delayedText.getText());
       
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));
        String lateText = driver.findElement(By.tagName("h3")).getText();
        System.out.println(lateText);

        driver.quit();
    }
}

