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

    #click on PIM
    driver.find_element(By.ID,"menu_pim_viewPimModule").click()

    #click on Add button
    driver.find_element(By.ID,"btnAdd").click()

    #Fill the required fields and click save
    driver.find_element((By.ID,"firstName")).send_keys("Raja")
    driver.find_element(By.ID,"lastName").send_keys("Khan")
    #click on save
    driver.find_element(By.ID,"btnSave").click()
    #Navigate back to PIM page
    driver.find_element(By.ID,"menu_pim_viewPimModule").click()

    #search for the user created
    driver.find_element(By.ID,"empsearch_employee_name_empName").send_keys("Raja Khan")
    driver.find_element(By.ID,"searchBtn").click()

    #close the browser
    driver.close()

