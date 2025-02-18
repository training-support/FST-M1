# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

# Start the Driver
with webdriver.Firefox() as driver:
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/selects")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the dropdown
    dropdown = driver.find_element(By.CSS_SELECTOR, "select.h-10")
    # Pass the WebElement to the Select object
    singleSelect = Select(dropdown)

    # Select the second option using visible text
    singleSelect.select_by_visible_text("Two")
    # Print the selected option
    print("Second option: " + singleSelect.first_selected_option.text)

    # Select the third option using index
    singleSelect.select_by_index(3)
    # Print the selected option
    print("Third option: " + singleSelect.first_selected_option.text)

    # Select the fourth option using value attribute
    singleSelect.select_by_value("four")
    # Print the selected option
    print("Fourth option: " + singleSelect.first_selected_option.text)

    # Print all the options
    allOptions = singleSelect.options
    print("Options in the dropdown: ")
    for option in allOptions: 
        print(option.text)