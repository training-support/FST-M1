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
    driver.find_element(By.ID,"user_name").send_keys("admin")
    driver.find_element(By.ID,"username_password").send_keys("pa$$w0rd")
    driver.find_element(By.ID,"bigbutton").click()
    wait = WebDriverWait(driver,10)
    tabname = driver.find_element(By.ID,"grouptab_3").text
    print("tab 3 value",tabname)
    print("activities tab is present :",driver.find_element(By.ID,"grouptab_3").is_displayed())



