package Project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CRM_Activity9 {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Set up method : Open a browser
	@BeforeClass
	public void setUp() {
		// Initialize Chrome driver
		driver = new ChromeDriver();
		// Navigate to ‘http://alchemy.hguy.co/crm’.
		driver.get("http://alchemy.hguy.co/crm");
	}

	@Test(priority = 1)
	public void login() {
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		String homePageUrl = driver.getCurrentUrl();
		Assert.assertTrue(homePageUrl.contains("Home"), "Login Failed !");

	}

	
	@Test(priority = 2)
	public void getLeadsNameAndUser() throws InterruptedException {
		driver.manage().window().maximize();
		
		// create an empty list and add expected Leads Names
		List<String> expectedLeadsNames= new ArrayList<String>();
		expectedLeadsNames.add("Miss second Name activity");
		expectedLeadsNames.add("Miss Test12 activity");
		expectedLeadsNames.add("Miss Test17 activity");
		expectedLeadsNames.add("Miss Test20 activity");
		expectedLeadsNames.add("Miss Test31 activity");
		expectedLeadsNames.add("Miss Test38 activity");
		expectedLeadsNames.add("Miss Test39 activity");
		expectedLeadsNames.add("Miss Test39 activity");
		expectedLeadsNames.add("Miss Test41 activity");
		expectedLeadsNames.add("Miss Test64 activity");
//		 System.out.println("list1:" + expectedLeadsNames);
		
		// create an empty list and add expected Leads Users
				List<String> expectedLeadsUsers = new ArrayList<String>();
				expectedLeadsUsers.add("chris");
				expectedLeadsUsers.add("admin");
				expectedLeadsUsers.add("chris");
				expectedLeadsUsers.add("chris");
				expectedLeadsUsers.add("admin");
				expectedLeadsUsers.add("chris");
				expectedLeadsUsers.add("chris");
				expectedLeadsUsers.add("chris");
				expectedLeadsUsers.add("chris");
				expectedLeadsUsers.add("admin");
//				 System.out.println("list2:" + expectedLeadsUsers);
				
		
//				Navigate to the Sales -> Accounts page
				driver.findElement(By.id("grouptab_0")).click();
				driver.findElement(By.id("moduleTab_9_Leads")).click();
				Thread.sleep(2000);
				String actualPageTitle = driver.findElement(By.className("module-title-text")).getText().strip();
				String expectedPageTitle = "LEADS";
				Assert.assertEquals(actualPageTitle, expectedPageTitle);
				List<WebElement> names =driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr/td[3]"));
				List<WebElement> users =driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr/td[8]"));
				List<String> actualLeadsNames = new ArrayList<String>();
				List<String> actualLeadsUsers = new ArrayList<String>();
				for(int i=1;i<10;i++) {
					actualLeadsNames.add(names.get(i).getText());
					actualLeadsUsers.add(users.get(i).getText());
				}
				 System.out.println("list1:" + actualLeadsNames);
				 System.out.println("list2:" + actualLeadsUsers);
				 Assert.assertEquals(actualLeadsNames, expectedLeadsNames);
				 Assert.assertEquals(actualLeadsUsers, expectedLeadsUsers);
				 
			}
			
			@AfterClass
			public void tearDown() {
				// Close the browser.
				driver.close();
			}
		
	
	
}
