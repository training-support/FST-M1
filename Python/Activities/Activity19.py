# Import pandas
import pandas
from pandas import ExcelWriter

# Create a dictionary that will be used to create the DataFrame
data = {
	'FirstName':["Satvik", "Avinash", "Lahri"],
	'LastName':["Shah", "Kati", "Rath"],
	'Email':["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
	'PhoneNumber':["4537829158", "4892184058", "4528727830"]
}

dataframe = pandas.DataFrame(data)

print(dataframe)
writer = ExcelWriter('sample.xlsx')
dataframe.to_excel(writer, 'Sheet1', index = False)

writer.save()