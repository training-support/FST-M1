# Logging into the site
# Goal: Open the site and login with the credentials provided

# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Chrome() as driver:

    driver.get("https://alchemy.hguy.co/crm/")

# Find and select the username and password fields
# Enter login credentials into the respective fields
    driver.find_element(By.ID,"user_name").send_keys("admin")
    driver.find_element(By.ID,"username_password").send_keys("pa$$w0rd")
    driver.find_element(By.ID,"bigbutton").click()
    homePageHeader = driver.find_element(By.ID,"tab0").text
    # print(homePageHeader)
if(homePageHeader=="SUITECRM DASHBOARD"):
        print("Home Page Opened Successfully !")
else:
        print("Login failed !")
# Close the browser
driver.quit()