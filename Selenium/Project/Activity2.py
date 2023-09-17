#Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:

    # Navigate to the URL
    driver.get("http://alchemy.hguy.co/orangehrm")

    # print the URL
    print ("URL: http://alchemy.hguy.co/orangehrm")

    #Close the browser
    driver.close()

