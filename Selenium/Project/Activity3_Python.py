from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.core import driver
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service)as driver:
    titlepage =  driver.get("https://alchemy.hguy.co/crm/")
    print("title of the page is :",driver.title)
    copyrighttext = driver.find_element(By.ID,"admin_options")
    print("copy right text is :",copyrighttext.text)
