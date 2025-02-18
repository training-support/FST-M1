# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver import Keys, ActionChains
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Firefox() as driver:
    # Declare the actions variable
    actions = ActionChains(driver)
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/keyboard-events")

    # Print the title of the page
    print("Page title is: ", driver.title)

    # Press the key
    actions.send_keys("This is coming from Selenium").send_keys(Keys.RETURN).perform()
    
    # Print the message from the page
    pageText = driver.find_element(By.CSS_SELECTOR, "h1.mt-3").text
    print(pageText)