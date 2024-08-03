import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JOB_PROJECT {
        private WebDriver driver;

        @BeforeTest
        public void setUp() {
            driver = new FirefoxDriver();
            driver.get("https://alchemy.hguy.co/jobs/");

        }

        @AfterTest
        public void tearDown() {
            //driver.quit();
            driver.close();

        }

        @Test
        public void Test1() {
            String title = driver.getTitle();
            Assert.assertEquals(title, "Alchemy Jobs – Job Board Application");


        }

        @Test
        public void Test2() {
            String Heading = driver.findElement(By.xpath("//h1[contains(text(),'Welcome to Alchemy Jobs')]")).getText();
            Assert.assertEquals(Heading, "Welcome to Alchemy Jobs");
        }

        @Test
        public void Test3() {
            String image_URL = driver.findElement(By.xpath("//header/div[@class='post-thumb-img-content post-thumb']/img")).getAttribute("src");
            System.out.println("Image URL :" + image_URL);
        }

        @Test
        public void Test4() {
            String Heading = driver.findElement(By.xpath("//h2")).getText();
            Assert.assertEquals(Heading, "Quia quis non");
        }

        @Test
        public void Test5() throws InterruptedException {
            driver.findElement(By.xpath("//a[text()='Jobs']")).click();
            Thread.sleep(3);
            String title = driver.getTitle();
            Assert.assertEquals(title, "Jobs – Alchemy Jobs");
        }


        @Test
        public void Test6() throws InterruptedException {
            driver.findElement(By.xpath("//a[text()='Jobs']")).click();
            Thread.sleep(3);
            driver.findElement(By.name("search_keywords")).sendKeys("Banking");
            driver.findElement(By.xpath("//input[@type='submit']")).click();
            Thread.sleep(3000);
            String Value = driver.findElement(By.xpath("//h3")).getText();
            Assert.assertEquals(Value, "Banking");
            driver.findElement(By.xpath("//h3")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@type='button']")).click();
            String Email = driver.findElement(By.className("job_application_email")).getText();
            Thread.sleep(1);
            System.out.println(Email);
        }

        @Test
        public void Test7() throws InterruptedException {
            driver.findElement(By.xpath("//a[text()='Post a Job']")).click();
            Thread.sleep(2000);
            driver.findElement(By.name("create_account_email")).sendKeys("Teasting12a3@gmail.com");
            driver.findElement(By.name("job_title")).sendKeys("Tester JOB");
            driver.findElement(By.name("job_location")).sendKeys("INDIA");
            driver.findElement(By.name("application")).sendKeys("Testingaa122@gmail.com");
            //driver.findElement(By.xpath("//body[@id='tinymce']/p")).sendKeys("Full Time Testing JOB");
            driver.findElement(By.name("company_name")).sendKeys("IBM");
            JavascriptExecutor js;
            WebElement e1 = driver.findElement(By.name("submit_job"));
            js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", e1);
            e1.click();
            Thread.sleep(2000);
            WebElement e2=driver.findElement(By.name("continue"));
            js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", e2);
            e2.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[text()='Jobs']")).click();
            Thread.sleep(3000);
            String Value = driver.findElement(By.xpath("(//h3)[2]")).getText();
            Assert.assertEquals(Value, "Tester JOB");
        }


        @Test
        public void Test8() throws InterruptedException {
            driver.get("https://alchemy.hguy.co/jobs/wp-admin");
            driver.findElement(By.name("log")).sendKeys("root");
            driver.findElement(By.name("pwd")).sendKeys("pa$$w0rd");
            driver.findElement(By.name("wp-submit")).click();
            Thread.sleep(3000);
            String value = driver.findElement(By.xpath("(//a/span[@class='display-name'])[1]")).getText();
            Assert.assertEquals(value, "root");
        }

        @Test
        public void Test9() throws InterruptedException {
            driver.get("https://alchemy.hguy.co/jobs/wp-admin");
            driver.findElement(By.name("log")).sendKeys("root");
            driver.findElement(By.name("pwd")).sendKeys("pa$$w0rd");
            driver.findElement(By.name("wp-submit")).click();
            Thread.sleep(3000);
            String JobName="New Test JOB";
            //driver.findElement(By.xpath("(//a/span[@class='ab-icon'])[1]")).click();
            //Thread.sleep(2000);
            driver.findElement(By.xpath("(//div[text()='Job Listings '])[1]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//a[text()='Add New'])[7]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//button[@type='button'])[27]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//textarea[@id='post-title-0']")).sendKeys(JobName);
            driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[text()='Publish']")).click();
            Thread.sleep(1000);
            String JOB_value=driver.findElement(By.xpath("(//div/a[text()='"+JobName+"'])//parent::div")).getText();
            Assert.assertEquals(JOB_value,JobName+" is now live.");
        }
    }
