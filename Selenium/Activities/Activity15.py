from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

# Start the Driver
with webdriver.Firefox() as driver:
    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/dynamic-attributes")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the input fields
    fullName = driver.find_element(By.XPATH, "//input[starts-with(@id, 'full-name')]")
    email = driver.find_element(By.XPATH, "//input[contains(@id, '-email')]")
    eventDate = driver.find_element(By.XPATH, "//input[contains(@name, '-event-date-')]")
    details = driver.find_element(By.XPATH, "//textarea[contains(@id, '-additional-details-')]")
    # Enter the details
    fullName.send_keys("Raiden Shogun")
    email.send_keys("raiden@electromail.com")
    eventDate.send_keys("2025-06-26")
    details.send_keys("It will be electric!")
    # Find and click the submit button
    driver.find_element(By.XPATH, "//button[text()='Submit']").click()

    # Wait for the success message and print it
    message = wait.until(EC.visibility_of_element_located((By.ID, "action-confirmation"))).text
    print("Success message: ", message)