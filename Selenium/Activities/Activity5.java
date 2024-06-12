package SeleniumPackage;

public class Activity5 {

	public static void main(String[] args) {
	
	 WebDriverManager.firefoxdriver().setup();
     
     WebDriver driver = new FirefoxDriver();
     
     driver.get("https://v1.training-support.net/selenium/target-practice");
     
     System.out.println("Home page title: " + driver.getTitle());
     
     builder.click().pause(1000).build().perform();
     
     String frontText = driver.findElement(By.className("active")).getText();
     System.out.println(frontText);

     
     builder.doubleClick().pause(1000).build().perform();
   
     frontText = driver.findElement(By.className("active")).getText();
     System.out.println(frontText);

     
     builder.contextClick().pause(1000).build().perform();
     
     frontText = driver.findElement(By.className("active")).getText();
     System.out.println(frontText);

    
     driver.close();
	}

}
