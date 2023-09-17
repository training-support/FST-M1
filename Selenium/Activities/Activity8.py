# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver import ActionChains, Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager


# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to URL
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    # Initialize wait object
    wait = WebDriverWait(driver, 10)

    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the checkbox div
    checkbox = driver.find_element(By.ID, "dynamicCheckbox")
    # Find the checkbox toggle button
    checkbox_toggle = driver.find_element(By.ID, "toggleCheckbox")

    # Click the checkbox_toggle button to hide checkbox
    checkbox_toggle.click()
    print("Checkbox hidden")
    # Wait till the checkbox diappears
    wait.until(expected_conditions.invisibility_of_element(checkbox))
    # Click the toggle button again
    checkbox_toggle.click()
    print("Checkbox visible")
    # Click the checkbox
    checkbox.click()
    print("Checkbox selected")
