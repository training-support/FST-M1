package SeleniumPackage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity7 {
    public static void main(String[] args) {
        
        WebDriverManager.firefoxdriver().setup();
       
        WebDriver driver = new FirefoxDriver();
      
        Actions builder = new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/drag-drop");
        
        System.out.println("Home page title: " + driver.getTitle());

        WebElement football = driver.findElement(By.id("draggable"));
       
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
      
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

        builder.clickAndHold(football).moveToElement(dropzone1).pause(2000).release().build().perform();
       
        String dropzone1Verify = dropzone1.findElement(By.tagName("p")).getText();
        if(dropzone1Verify.equals("Dropped!")) {
            System.out.println("Ball was dropped in dropzone 1");
        }
        
        builder.dragAndDrop(football, dropzone2).build().perform();

        String dropzone2Verify = dropzone2.findElement(By.tagName("p")).getText();
        if(dropzone2Verify.equals("Dropped!")) {
            System.out.println("Ball was dropped in dropzone 2");
        }

       
        driver.close();
    }
}