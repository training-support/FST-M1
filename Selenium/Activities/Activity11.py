# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

# Start the Driver
with webdriver.Firefox() as driver:
    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/dynamic-controls")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the checkbox and make sure it is visible
    checkbox = driver.find_element(By.ID, "checkbox")
    print("Checkbox is visible? ", checkbox.is_displayed())

    # Find the button to toggle it and click it
    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()
    # Wait for it to disappear
    wait.until(EC.invisibility_of_element(checkbox))
    # Check if it is visible
    print("Checkbox is visible? ", checkbox.is_displayed())

    # Toggle the checkbox and click it
    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()
    wait.until(EC.element_to_be_clickable(checkbox)).click()
    # Check if it is selected
    print("Checkbox is selected? ", checkbox.is_selected())