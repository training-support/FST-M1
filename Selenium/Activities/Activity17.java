public class Activity17 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("https://v1.training-support.net/selenium/selects");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find the dropdown
        WebElement dropdown = driver.findElement(By.id("single-select"));

        // Pass the WebElement to the Select object
        Select singleSelect = new Select(dropdown);

        // Select the second option using visible text
        singleSelect.selectByVisibleText("Option 2");
        // Print the selected option
        System.out.println("Second option: " + singleSelect.getFirstSelectedOption().getText());

        // Select the third option using index
        singleSelect.selectByIndex(3);
        // Print the selected option
        System.out.println("Third option: " + singleSelect.getFirstSelectedOption().getText());

        // Select the fourth option using value attribute
        singleSelect.selectByValue("4");
        // Print the selected option
        System.out.println("Fourth option: " + singleSelect.getFirstSelectedOption().getText());

        // Print all the options
        List<WebElement> allOptions = singleSelect.getOptions();
        System.out.println("Options in the dropdown: ");
        for(WebElement option : allOptions) {
            System.out.println(option.getText());
        }

        // Close the browser
        driver.quit();
    }
}
