package orangeHrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		//Open the browser
		driver.get("http://alchemy.hguy.co/orangehrm\r\n");
		String title = driver.getTitle();
        String original="OrangeHRM";
        if(title.equals(original))
        {
        	System.out.println(title);
        	driver.close();
        }
        
	}

}
