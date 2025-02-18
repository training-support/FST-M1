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
    driver.get("https://training-support.net/webelements/popups")
    # Print the title of the page
    print("Page title is: ", driver.title)
    # Find the launcher button and click it
    driver.find_element(By.ID, "launcher").click()

    # Wait for the modal to appear
    wait.until(EC.element_to_be_clickable((By.ID, "username")))

    # Find the input fields
    username = driver.find_element(By.ID, "username")
    password = driver.find_element(By.ID, "password")
    # Enter the credentials
    username.send_keys("admin")
    password.send_keys("password")
    # Click the submit button
    driver.find_element(By.XPATH, "//button[text()='Submit']").click()

    # Print the success message
    message = driver.find_element(By.CSS_SELECTOR, "h2.text-center").text
    print("Login message: " + message)