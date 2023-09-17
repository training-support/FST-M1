# Import pandas
import pandas
from pandas import ExcelWriter

# Create a dictionary that will be used to create the DataFrame
data = {
    'FirstName': ["Nishaj", "Surya", "Arjun"],
    'LastName': ["Raj", "Varma", "Thilak"],
    'Email': ["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
    'PhoneNumber': ["4535689158", "4892184999", "4528728456"]
}

# Create the DataFrame that will be written to the excel file
dataframe = pandas.DataFrame(data)

# Print the dataframe
print(dataframe)

# Write the dataframe to a Excel file
writer = ExcelWriter('sample.xlsx')
dataframe.to_excel(writer, 'Sheet1', index=False)

# Commit data to the Excel file
writer.save()
