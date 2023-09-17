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
    driver.find_element(By.LINK_TEXT,"Dashboard").click()
    driver.find_element(By.LINK_TEXT,"Apply Leave").click()
    driver.find_element(By.ID,"applyleave_txtLeaveType").click()
    driver.find_element(By.ID,"applyleave_txtLeaveType").send_keys("Dayoff")
    driver.find_element(By.ID,"applyleave_txtFromDate").click()
    driver.find_element(By.CLASS_NAME,"ui-datepicker-trigger").click()
    driver.find_element(By.ID,"applyleave_txtFromDate").send_keys("2023-12-01")
    driver.find_element(By.ID,"applyBtn").click()
    time.sleep(100)
    driver.find_element(By.ID,"menu_leave_viewMyLeaveList").click()
    driver.close()
