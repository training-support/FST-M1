username = input("Enter Username:")
age = input("Age is:")
yearsToTurnHundred = 100-int(age)
print("My name is: "+username)
print("My current Age is: "+age)
txt ="It will take {} years for me to turn 100"
print(txt.format(yearsToTurnHundred))
year = 2024+yearsToTurnHundred
txtyear = "It means I will turn 100 years old on {}"
print(txtyear.format(year))