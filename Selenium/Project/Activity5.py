import time
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("http://alchemy.hguy.co/orangehrm")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the username field
    Username = driver.find_element(By.ID, "txtUsername")
    # Find the password field
    Password = driver.find_element(By.ID, "txtPassword")

    # Enter the given credentials
    # Enter username
    Username.send_keys("orange")
    # Enter password
    Password.send_keys("orangepassword123")

    #click the login button
    driver.find_element(By.ID, "btnLogin").click()

    #click My Info
    driver.find_element(By.LINK_TEXT,"My Info").click()
    driver.find_element(By.ID,"btnSave").click()

    #Fill the required fields and click save
    driver.find_element(By.ID,"personal_txtEmpFirstName")
    driver.find_element(By.ID,"personal_txtEmpLastName")
    driver.find_element(By.ID,"personal_optGender_1")
    driver.find_element(By.ID,"personal_DOB")

    #click on save button
    driver.find_element(By.ID,"btnSave")
    time.sleep(100)
    driver.close()