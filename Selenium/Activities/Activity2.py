# Set up the Firefox Driver with WebDriverManger
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("https://www.training-support.net/selenium/login-form")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the username field
    username = driver.find_element(By.ID, "username")
    # Find the password field
    password = driver.find_element(By.ID, "password")

    # Enter the given credentials
    # Enter username
    username.send_keys("admin")
    # Enter password
    password.send_keys("password")

    # Find the login button
    login = driver.find_element(By.CSS_SELECTOR, "button.button:nth-child(4)")
    login.click()

    # Print the login message
    message = driver.find_element(By.ID, "action-confirmation")
    print("Login message: ", message.text)
