# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Firefox() as driver:
    # Declare the actions variable
    actions = ActionChains(driver)
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/mouse-events")

    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the elements that can be clicked
    cargoLock = driver.find_element(By.XPATH, "//h1[text()='Cargo.lock']")
    cargoToml = driver.find_element(By.XPATH, "//h1[text()='Cargo.toml']")
    srcButton = driver.find_element(By.XPATH, "//h1[text()='src']")
    targetButton = driver.find_element(By.XPATH, "//h1[text()='target']")

    # Perform left click on Cargo.lock and then on Cargo.toml
    actions.click(cargoLock).pause(1).move_to_element(cargoToml).pause(5).click(cargoToml).perform()
    # Print the front side text
    actionMessage = driver.find_element(By.ID, "result").text
    print(actionMessage)

    # Perform double click on src then right click on target
    actions.double_click(srcButton).pause(3).pause(5).context_click(targetButton).pause(3).perform()
    # and then open it
    actions.click(driver.find_element(By.XPATH, ("//div[@id='menu']/div/ul/li[1]"))).pause(5).perform()
    # Print the front side text
    actionMessage = driver.find_element(By.ID, "result").text
    print(actionMessage)