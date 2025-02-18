# Get the url of the header image
# Goal: Print the url of the header image to the console
# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Chrome() as driver:

    driver.get("https://alchemy.hguy.co/crm/")

#  Get the url of the header image.
#  Print the url to the console.
    headerImage = driver.find_element(By.XPATH, "//div/img")
    actualUrl = headerImage.get_attribute("src")
    print("The url in Image is : " + actualUrl)
# Close the browser
    driver.quit()

