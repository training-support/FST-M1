username = input("Enter username: ")
age = input("Enter age: ")
years = (2021 - int(age))+100
details = (username + " will turn 100 years in the year: {}")
print(details.format(years))

