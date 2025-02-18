# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Firefox() as driver:
    # Declare the actions variable
    actions = ActionChains(driver)
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/drag-drop")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the football
    football = driver.find_element(By.ID, "ball")
    # Find the dropzone1
    dropzone1 = driver.find_element(By.ID, "dropzone1")
    # Find the dropzone2
    dropzone2 = driver.find_element(By.ID, "dropzone2")

    # Perform drag and drop to dropzone 1
    actions.click_and_hold(football).move_to_element(dropzone1).pause(5).release().perform()
    if(dropzone1.find_element(By.CLASS_NAME, "dropzone-text").text == "Dropped!"):
        print("Ball was dropped in Dropzone 1")

    # Perform drag and drop to dropzone 2
    actions.drag_and_drop(football, dropzone2).pause(5).perform()
    if(dropzone2.find_element(By.CLASS_NAME, "dropzone-text").text == "Dropped!"):
        print("Ball was dropped in Dropzone 2")