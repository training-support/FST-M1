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
    driver.get("https://training-support.net/webelements/tabs")
    # Print the title of the page
    print("Page title is: ", driver.title)
    # Print the handle of the parent window
    print("Current tab: ", driver.current_window_handle)

    # Find button to open new tab
    wait.until(EC.element_to_be_clickable((By.XPATH, "//button[text()='Open A New Tab']"))).click()
    # Wait for the second tab to open
    wait.until(EC.number_of_windows_to_be(2))
    # Print all window handles
    print("Currently open windows: ", driver.window_handles)
    driver.switch_to.window(driver.window_handles[1])

    # Wait for the new page to load
    wait.until(EC.element_to_be_clickable((By.XPATH, "//button[contains(text(), 'Another One')]")))
    # Print the handle of the current tab
    print("Current tab: ", driver.current_window_handle)
    # Print the title and heading of the new page
    print("New Page title: ", driver.title)
    print("New Page message: ", driver.find_element(By.CSS_SELECTOR, "h2.mt-5").text)
    # Find and click the button on page to open another tab
    driver.find_element(By.XPATH, "//button[contains(text(), 'Another One')]").click()

    # Wait for new tab to open
    wait.until(EC.number_of_windows_to_be(3))
    # Switch focus
    for handle in driver.window_handles:
        driver.switch_to.window(driver.window_handles[2])