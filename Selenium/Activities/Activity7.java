import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        Actions builder = new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/drag-drop");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find the football
        WebElement football = driver.findElement(By.id("draggable"));
        // Find the dropzone1
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        // Find the dropzone2
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

        builder.clickAndHold(football).moveToElement(dropzone1).pause(2000).release().build().perform();
        String dropzone1Verify = dropzone1.findElement(By.tagName("p")).getText();
        if(dropzone1Verify.equals("Dropped!")) {
            System.out.println("Ball was dropped in dropzone 1");
        }

        // Perform drag and drop to dropzone 2
        builder.dragAndDrop(football, dropzone2).build().perform();
        // Verify that the ball was dropped in dropzone 2
        String dropzone2Verify = dropzone2.findElement(By.tagName("p")).getText();
        if(dropzone2Verify.equals("Dropped!")) {
            System.out.println("Ball was dropped in dropzone 2");
        }
        driver.quit();
    }
}
