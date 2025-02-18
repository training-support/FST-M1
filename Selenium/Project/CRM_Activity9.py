# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
import time

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

# Navigate to the Sales -> Leads page
    driver.fullscreen_window()
    driver.find_element(By.ID,"grouptab_0").click()
    driver.find_element(By.ID,"moduleTab_9_Leads").click()
    time.sleep(2)
# Find the table on the page and print the names of the first 5 odd-numbered rows of the table to the console
    print("The first ten Leads names and users are : ")
    leadsNames = driver.find_elements(By.XPATH,"//table[@class='list view table-responsive']/tbody/tr/td[3]")
    leadsUsers = driver.find_elements(By.XPATH,"//table[@class='list view table-responsive']/tbody/tr/td[8]")
    for x in range(1, 11, 1):
        print(x,leadsNames[x].text,":",leadsUsers[x].text)
    
#Close the browser
    driver.quit()