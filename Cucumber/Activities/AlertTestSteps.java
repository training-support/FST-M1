package CucumberPgms;

public class AlertTestSteps {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;
 
    @Given("^User is on the page$")
    public void openPage() {
        //Create Instances
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
 
        //Open browser
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }
 
    @When("^User clicks the Simple Alert button$")
    public void openSimpleAlert() {
        driver.findElement(By.cssSelector("#simple")).click();
    }
 
    @When("^User clicks the Confirm Alert button$")
    public void openConfirmAlert() {
        driver.findElement(By.cssSelector("#confirm")).click();
    }
 
    @When("^User clicks the Prompt Alert button$")
    public void openPromptAlert() {
        driver.findElement(By.cssSelector("#prompt")).click();
    }
 
    @Then("^Alert opens$")
    public void switchFocus() {
        alert = driver.switchTo().alert();
    }
 
    @And("^Read the text from it and print it$")
    public void readAlert() {
        System.out.println("Alert says: " + alert.getText());
    }
 
    @And("^Write a custom message in it$")
    public void writeToPrompt() {
        alert.sendKeys("Custom Message");
    }
 
    @And("^Close the alert$")
    public void closeAlert() {
        alert.accept();
    }
 
    @And("^Close the alert with Cancel$")
    public void closeAlertWithCAncel() {
        alert.dismiss();
    }
 
    @And("^Close Browser$")
    public void closeBrowser() {
        driver.close();
    }
}