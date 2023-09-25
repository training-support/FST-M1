import pandas
dataframe = pandas.read_csv("Activity17.csv")

print("Usernames:")
print(dataframe["Usernames"])

print("Username: ", dataframe["Usernames"][1], " | ", "Password: ", dataframe["Passwords"][1])

print("Username in ascending order:")
print(dataframe.sort_values('Usernames', ascending=True))

print("Password in descending order:")
print(dataframe.sort_values('Passwords', ascending=False))