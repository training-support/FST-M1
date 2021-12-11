
# Import pandas
import pandas

dataframe = pandas.read_excel('C:\\Users\\0027MT744\\Desktop\\sample.xlsx')

print(dataframe)

print("====================================")
print("Number of rows and columns:", dataframe.shape)

print("====================================")
print("Emails:")
print(dataframe['Email'])

print("====================================")
print("Sorted data:")
print(dataframe.sort_values('FirstName'))