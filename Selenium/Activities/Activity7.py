# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Firefox() as driver:
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/dynamic-controls")

    # Print the title of the page
    print("Page title is: ", driver.title)
    
	# Find the checkbox
    textbox = driver.find_element(By.ID, "textInput")
    # Verify if the checkbox is enabled or not
    print("Textbox is enabled: ", textbox.is_enabled())
    # Click it again
    driver.find_element(By.ID, "textInputButton").click()
    # Verify again if the textbox is enabled or not
    print("Textbox is enabled: ", textbox.is_enabled())