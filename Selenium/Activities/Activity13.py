# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("https://v1.training-support.net/selenium/tables")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Get number of columns
    columns = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[1]/td")
    print("Number of columns: ", len(columns))
    # Get number of rows
    rows = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr")
    print("Number of rows: ", len(rows))

    # Get cell values from the third row
    third_row = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[3]/td")
    # Print them one by one using a loop
    print("Cell values of third row:")
    for row in third_row:
        print("Cell value: ", row.text)

    # Get cell value from the second row and second column
    # Use "find_element" instead of "find_elements" because only one cell is needed
    second_row_second_cell = driver.find_element(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]")
    # Print the cell value
    print("Cell value at second row and second column: ", second_row_second_cell.text)