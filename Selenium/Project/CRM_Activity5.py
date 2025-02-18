# Getting colors
# Goal: Get the color of the navigation menu

# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.color import Color

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

# Get the color of the navigation menu and print it to the console.
    nav_menu_color = Color.from_string(driver.find_element(By.ID, "toolbar").value_of_css_property("color"))
    print("Navigation Menu colour as Hexcode: ", nav_menu_color.hex)
    print("Navigation Menu colour as RGB: ", nav_menu_color.rgb)

# Close the browser
    driver.quit()