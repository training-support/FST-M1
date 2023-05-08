import pandas

dataframe = pandas.read_excel('../resources/Act19file.xlsx')
print(dataframe)
print("\n Number of rows and columns:", dataframe.shape)
print("Emails:", dataframe['Email'])
print("Sorted by First Name: ", dataframe.sort_values('FirstName'))
