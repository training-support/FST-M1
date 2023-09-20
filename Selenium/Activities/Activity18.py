# Set up the Firefox Driver with WebDriverManger
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.select import Select
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("https://www.training-support.net/selenium/selects")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the multiselect list
    multiselect_list = driver.find_element(By.ID, "multi-select")
    # Pass the multiselect WebElement to the Select class and initialize the select object
    multiselect = Select(multiselect_list)

    # Select the "Javascript" option using the visible text.
    multiselect.select_by_visible_text("Javascript")
    # Print the selected options using the all_selected_options method
    # all_selected_options returns a list.
    # Use a for loop to get the name of the selected options
    for option in multiselect.all_selected_options:
        print("Options selected are: ", option.text)

    # Select the 4th, 5th and 6th options using the index.
    for x in range(4, 6):
        multiselect.select_by_index(x)
    for option in multiselect.all_selected_options:
        print("Options selected are: ", option.text)

    # Select the "NodeJS" option using the value.
    multiselect.select_by_value("node")
    for option in multiselect.all_selected_options:
        print("Options selected are: ", option.text)

    # Deselect the "Javascript" option using index.
    multiselect.deselect_by_index(7)
    for option in multiselect.all_selected_options:
        print("Options selected are: ", option.text)
