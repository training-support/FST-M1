import pandas

dataframe = pandas.read_excel('data.xlsx')

print(dataframe)
print("Number of rows and columns are:", dataframe.shape)

print("Emails:")
print(dataframe['Email'])

print("FirstName in ascending order")
print(dataframe.sort_values('FirstName'))