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
    # Navigate to the URL
    driver.get("https://v1.training-support.net/selenium/ajax")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Initialize the wait object
    wait = WebDriverWait(driver, 10)

    # Find the "Change Content" button and click it
    driver.find_element(By.CSS_SELECTOR, "button.violet").click()
    # Wait for the text "HELLO!" to appear
    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h1"), "HELLO!"))
    hello_text = driver.find_element(By.TAG_NAME, "h1").text
    # Print the text
    print(hello_text)

    # Wait for "I'm late!" to appear
    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h3"), "I'm late!"))
    late_text = driver.find_element(By.TAG_NAME, "h3").text
    # Print the text
    print(late_text)