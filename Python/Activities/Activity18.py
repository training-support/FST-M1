import pandas

dataframe = pandas.read_csv("../resources/est1.csv")
print(dataframe)

print("\n Usernames:")
print(dataframe["Usernames"])

print("\n Username: ", dataframe["Usernames"][1], " | ", "Password: ", dataframe["Passwords"][1])

print("\n Data sorted in ascending Usernames:")
print(dataframe.sort_values('Usernames', ascending=True))

print("\n Data sorted in descending Passwords:")
print(dataframe.sort_values('Passwords', ascending=False))
