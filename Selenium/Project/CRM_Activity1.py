# Goal: Read the title of the website and verify the text

# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Chrome() as driver:

    driver.get("https://alchemy.hguy.co/crm/")
# Get the title of the website.
# Make sure it matches “SuiteCRM” exactly
  
    if(driver.title=="SuiteCRM"):
        print ("The Page title is : ",driver.title)
    else:
         print ("Wrong Page opened ! ")

# close the browser.
    driver.quit()
