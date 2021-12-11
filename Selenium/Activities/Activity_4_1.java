package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity_4_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0027MT744\\Desktop\\FullStackTester\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
 
        driver.get("https://www.training-support.net");

        
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
 
        driver.findElement(By.xpath("/html/body/div/div/div/a")).click();

        System.out.println("Heading is: " + driver.getTitle());

        driver.close();
	}

}
