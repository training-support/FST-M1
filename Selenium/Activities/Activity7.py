# Set up the Firefox Driver with WebDriverManger
from selenium import webdriver
from selenium.webdriver import ActionChains, Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("https://www.training-support.net/selenium/drag-drop")

    # Print the title of the page
    print("Page title is: ", driver.title)

    # Declare the actions variable
    actions = ActionChains(driver)

    # Find the ball and store it
    ball = driver.find_element(By.ID, "draggable")
    # Find the dropzones and save them
    dropzone1 = driver.find_element(By.ID, "droppable")
    dropzone2 = driver.find_element(By.ID, "dropzone2")

    # Perform the actions in separate lines
    actions.drag_and_drop(ball, dropzone1).perform()  # drag the ball into dropzone1
    if (dropzone1.text.find("Dropped!")):
        print("Dropzone 1 was activated!")

    # Perform the actions in separate lines
    actions.drag_and_drop(ball, dropzone2).perform()  # drag the ball into dropzone2
    if (dropzone2.text.find("Dropped!")):
        print("Dropzone 2 was activated!")
