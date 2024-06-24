package activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Activity1 {
    WebDriver driver;
    String title;
    @BeforeClass
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void get(){
        driver.get("http://v1.training-support.net/");
    }
    /*@Test(priority = 1)
    public void  getTitle(){
        title= driver.getTitle();
        Assert.assertEquals(title,"Training Support");
        //System.out.println("Title:" +title);
    }

    @Test(priority = 2)
    public void findElement(){
        driver.findElement(By.id("about-link")).click();
        title= driver.getTitle();
        Assert.assertEquals(title,"About Training Support");
        System.out.println("Title:" +title);
    }*/
    @AfterClass
    public void closebrowser(){
        driver.close();
    }
}
