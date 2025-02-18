package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
public class Activity3 {
	
	WebDriver driver; //declared outside the function, because we can use it in any no. of functions.
	
	  @BeforeClass
	  public void setUp() {
		  
		  driver = new ChromeDriver();
		  //Open the page
		  driver.get("https://training-support.net/webelements/login-form");
	  }
	 
	  @Test (priority = 1)
	  public void pageTitleTest() {
		  //Get the page title
		  //String pageTitle = driver.getTitle();
		  //Get the page title and verify it
		  assertEquals(driver.getTitle(), "Selenium: Login Form");
	  }
	 
	  @Test(priority = 2)
	  public void loginFormTest() {
		  //Find the login input fields - username and password
		  driver.findElement(By.id("username")).sendKeys("admin");
		  driver.findElement(By.id("password")).sendKeys("password");
		  //Find the submit button and click it
		  driver.findElement(By.xpath("//button[text()='Submit']")).click();
		 
		  //verify the login message
		  String message = driver.findElement(By.tagName("h2")).getText();
		  assertEquals(message, "Welcome Back, Admin!");
	  }
	  @AfterClass
	  public void tearDown() {
		  //close the browser
		  driver.quit();
	  }
}
