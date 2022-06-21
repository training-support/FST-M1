import pandas


data = {
  "Usernames": ["admin", "Charles", "Deku"],
  "Passwords": ["password", "Charl13", "AllMight"]
}

# Creating a DataFrame using stored data
dataframe = pandas.DataFrame(data)

# Printing DataFrame
print(dataframe)

"""
 Write the DataFrame to a CSV file
 To avoid writing the index numbers to the file as well
 the index property is set to false
"""
dataframe.to_csv("employee.csv", index=False)