
import pandas

dataframe = pandas.read_csv("sample.csv")

print("Full Data: ")
print(dataframe)

print("===============")
print("Usernames:")
print(dataframe["Usernames"])

print("===============")
print("Username: ", dataframe["Usernames"][1], " | ", "Password: ", dataframe["Passwords"][1])

print("====================================")
print("Data sorted in ascending Usernames:")
print(dataframe.sort_values('Usernames'))

print("====================================")
print("Data sorted in descending Passwords:")
print(dataframe.sort_values('Passwords', ascending=False))