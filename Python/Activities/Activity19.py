# Import pandas
import pandas
from pandas import ExcelWriter

data = {
	'FirstName':["Satvik", "Avinash", "Lahri"],
	'LastName':["Shah", "Kati", "Rath"],
	'Email':["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
	'PhoneNumber':["4537829158", "4892184058", "4528727830"]
}

dataframe = pandas.DataFrame(data)

print(dataframe)

writer = ExcelWriter('C:\\Users\\0027MT744\\Desktop\\sample.xlsx')
dataframe.to_excel(writer, 'Sheet1', index = False)

writer.save()