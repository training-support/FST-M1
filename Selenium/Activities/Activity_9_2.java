package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity_9_2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://training-support.net/selenium/selects");

        WebElement chosen = driver.findElement(By.id("multi-value"));
        
        Select multiList = new Select(driver.findElement(By.id("multi-select")));
        
        if(multiList.isMultiple()) {

            multiList.selectByVisibleText("Javascript");
            System.out.println(chosen.getText());

            
            multiList.selectByValue("node");
            System.out.println(chosen.getText());

            for(int i=4; i<=6; i++) {
                multiList.selectByIndex(i);
            }
            System.out.println(chosen.getText());

            multiList.deselectByValue("node");
            System.out.println(chosen.getText());
            
            multiList.deselectByIndex(7);
            System.out.println(chosen.getText());

            List<WebElement> selectedOptions = multiList.getAllSelectedOptions();

            for(WebElement selectedOption : selectedOptions) {
                System.out.println("Selected option: " + selectedOption.getText());
            }

            multiList.deselectAll();
            System.out.println(chosen.getText());
        }        

        driver.close();
    }

}
