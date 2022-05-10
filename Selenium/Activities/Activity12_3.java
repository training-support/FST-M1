package activities;

public class Activity12_3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions builder = new Actions(driver);

        //Open browser
        driver.get("https://www.training-support.net/selenium/popups");

        //Find Sign in button
        WebElement button = driver.findElement(By.xpath("//button[contains(@class, 'orange')]"));

        //Hover over button
        builder.moveToElement(button).pause(Duration.ofSeconds(1)).build().perform();
        String tooltipText = button.getAttribute("data-tooltip");
        System.out.println("Tooltip text: " + tooltipText);

        //Click on the button
        button.click();

        //Wait for modal to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));

        //Find username and pasword and fill in the details
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        //Read the login message
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println(message);

        //Close browser
        driver.close();
    }
}