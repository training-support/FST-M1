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
    selectElement = driver.find_element(By.CSS_SELECTOR, "select.h-80")
    # Pass the WebElement to the Select object
    multiSelect = Select(selectElement)

    # Select "HTML" using visible text
    multiSelect.select_by_visible_text("HTML")
    # Select 4th, 5th, and 6th index options
    for i in range(3, 5):
        multiSelect.select_by_index(i)
    # Select "Node" using value attribute
    multiSelect.select_by_value("nodejs")
    # Print the selected options
    selectedOptions = multiSelect.all_selected_options
    print("Selected options are: ")
    for option in selectedOptions:
        print(option.text)

    # Deselect the 5th index option
    multiSelect.deselect_by_index(4)
    # Print the selected options
    selectedOptions = multiSelect.all_selected_options
    print("Selected options are: ")
    for option in selectedOptions:
        print(option.text)