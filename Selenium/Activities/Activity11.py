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
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the checkbox
    checkbox = driver.find_element(By.CSS_SELECTOR, "input.willDisappear")
    # Click the checkbox to select it
    checkbox.click()
    # Verify if the checkbox is selected or not
    print("Checkbox is selected: ", checkbox.is_selected())
    # Click the checkbox again to uncheck it
    checkbox.click()
    # Verify if the checkbox is selected or not
    print("Checkbox is selected: ", checkbox.is_selected())