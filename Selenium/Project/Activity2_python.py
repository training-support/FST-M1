from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.core import driver
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service)as driver:
    titlepage = driver.get("https://alchemy.hguy.co/crm/")
    print("title of the page is :",driver.title)
    print("url of the image is :",driver.find_element(By.CSS_SELECTOR,'img').get_attribute("src"))
    #print("url of the image is :",urltitle.get_attribute("src"))
