import pandas

dataframe = pandas.read_csv("sample.csv")
print(dataframe)

#print the second row data

print("Username :",dataframe["Usernames"][1],"|","Password : " ,dataframe["Passwords"][1])

print("Data sorted in ascending Usernames:")
print(dataframe.sort_values('Usernames'))

print("Data sorted in descending Passwords:")
print(dataframe.sort_values('Passwords', ascending=False))