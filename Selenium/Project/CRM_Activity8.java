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

//Traversing tables
//Goal: Open the accounts page and print the contents of the table

public class CRM_Activity8 {
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
	public void openAccountsPage() throws InterruptedException {
		driver.manage().window().maximize();
//		Navigate to the Sales -> Accounts page
		driver.findElement(By.id("grouptab_0")).click();
		driver.findElement(By.id("moduleTab_9_Accounts")).click();
		Thread.sleep(2000);
		String actualAccountsPageHeading = driver.findElement(By.xpath("//h2[@class='module-title-text']")).getText()
				.strip();
		String expectedAccountsPageHeading = "ACCOUNTS";
		Assert.assertEquals(actualAccountsPageHeading, expectedAccountsPageHeading);
	}

	@Test(priority = 3)
	public void getAccountNames() throws InterruptedException {

		// create an empty list and add expected Account Names
		List<String> expectedAccountNames = new ArrayList<String>();
		expectedAccountNames.add("5D Investments");
		expectedAccountNames.add("A.D. Importing Company Inc");
		expectedAccountNames.add("AtoZ Co Ltd");
		expectedAccountNames.add("B.H. Edwards Inc");
		expectedAccountNames.add("Calm Sailing Inc");
		// System.out.println("list1:" + expectedAccountNames);

//		Find the table on the page and print the names of the first 5 odd-numbered rows of the table to the console
		List<WebElement> namesList = driver
				.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr/td[3]"));
		List<String> actualAccountNames = new ArrayList<String>();
		// Start from index 1 and increment by 2 until index 9
		for (int i = 1; i < 10; i += 2) {
			actualAccountNames.add(namesList.get(i).getText());
		}
		// System.out.print("list2:" + actualAccountNames);
		Assert.assertEquals(actualAccountNames, expectedAccountNames);
	}

	@AfterClass
	public void tearDown() {
		// Close the browser.
		driver.close();
	}

}