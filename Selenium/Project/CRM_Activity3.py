# Get the copyright text
# Goal: Print the first copyright text in the footer to the console

# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Chrome() as driver:
  
#  Navigate
  driver.get("https://alchemy.hguy.co/crm/")

# Get the first copyright text in the footer
  copyrightText = driver.find_element(By.ID, "admin_options").text
# Print the text to the console.
  print("The text in the Copyright in Footer is : ", copyrightText)

# Close the browser
  driver.quit()