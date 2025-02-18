# Reading additional information
# Goal: Reading a popup that contains additional information about the account/lead.
# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
import time

# Start the Driver
with webdriver.Chrome() as driver:

   driver.get("https://alchemy.hguy.co/crm/")
 
# Find the username field
   username = driver.find_element(By.ID, "user_name")
# Find the password field
   password = driver.find_element(By.ID, "username_password")

    # Enter the given credentials
    # Enter username
   username.send_keys("admin")
    # Enter password
   password.send_keys("pa$$w0rd")

    # Find the login button
   login = driver.find_element(By.XPATH, "//input[@type='submit']")
   login.click()

    #Function
   driver.maximize_window()
   time.sleep(2)

   salesMenu = driver.find_element(By.ID, "grouptab_0")
   salesMenu.click()
    
   leadsMenu = driver.find_element(By.ID, "moduleTab_9_Leads")
   leadsMenu.click()
   time.sleep(2)
   addDetIcon = driver.find_element(By.XPATH, "//span[@title='Additional Details']").click()
   time.sleep(2)
   mobileNumb =driver.find_element(By.XPATH, "//span[@class='phone']").text
   print("The mobile number is :" + mobileNumb)