import pandas

dataframe = pandas.read_excel("Employees.xlsx")
print(dataframe)

print("Number of rows and columns:", dataframe.shape)

print("Emails :")
print(dataframe['Email'])

print(dataframe.sort_values("FirstName"))
