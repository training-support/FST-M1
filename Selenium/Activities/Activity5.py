# Set up the Firefox Driver with WebDriverManger
from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Declare actions variable
    actions = ActionChains(driver)

    # Navigate to the URL
    driver.get("https://www.training-support.net/selenium/input-events")

    # Print the title of the page
    print("Page title is: ", driver.title)

    # Perform a LEFT CLICK action
    actions.click().perform()
    # Find the side that is active
    active_side = driver.find_element(By.CLASS_NAME, "active")
    # Print the number shown
    print("Active side number after left click: ", active_side.text)

    # Perform a DOUBLE CLICK action
    actions.double_click().perform()
    # Find the side that is active
    active_side = driver.find_element(By.CLASS_NAME, "active")
    # Print the number shown
    print("Active side number after double click: ", active_side.text)

    # Perform a RIGHT CLICK action
    actions.context_click().perform()
    # Find the side that is active
    active_side = driver.find_element(By.CLASS_NAME, "active")
    # Print the number shown
    print("Active side number after right click: ", active_side.text)
