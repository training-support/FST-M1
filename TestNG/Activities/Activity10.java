package activities;

import static org.testng.Assert.assertEquals;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity10 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open browser
        driver.get("https://training-support.net/webelements/simple-form");
    }

    public static List<List<String>> readExcel(String filePath) {
        List<List<String>> data = new ArrayList<List<String>>();
        try {
            FileInputStream file = new FileInputStream(filePath);

            // Create Workbook instance holding reference to Excel file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows one by one
            for (Row cells : sheet) {
                // Temp variable
                List<String> rowData = new ArrayList<String>();
                for (Cell cell : cells) {
                    // Store row data
                    rowData.add(cell.getStringCellValue());
                }
                // Store row data in List
                data.add(rowData);
            }
            file.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @DataProvider(name = "Events")
    public static Object[][] signUpInfo() {
        String filePath = "src/test/resources/Sample.xlsx";
        List<List<String>> data = readExcel(filePath);
        return new Object[][] { 
            { data.get(1) },
            { data.get(2) },
            { data.get(3) }
        };
    }

    @Test(dataProvider = "Events")
    public void registerTest(List<String> rows) throws InterruptedException {
        // Find the input fields and enter text
        WebElement fullName = driver.findElement(By.id("full-name"));
        fullName.sendKeys(rows.get(0));

        // Enter the email
        driver.findElement(By.id("email")).sendKeys(rows.get(1));

        // Enter the Date of the event
        driver.findElement(By.name("event-date")).sendKeys(rows.get(2).replaceAll("\"", ""));

        // Enter additional details
        driver.findElement(By.id("additional-details")).sendKeys(rows.get(3));

        // Click Submit
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        
        // Confirm booking
        String message = driver.findElement(By.id("action-confirmation")).getText();
        assertEquals(message, "Your event has been scheduled!");

        driver.navigate().refresh();
    }

    @AfterClass
    public void tearDown() {
       
        driver.quit();
    }
}
