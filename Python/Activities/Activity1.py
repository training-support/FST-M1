import datetime
Name=input("Enter Your Name: ")
Age=input("Enter Your age: ")
Current_year= datetime.date.today().year
calc1=Current_year+(100-int(Age))
print("You will turn 100 years old in the year of:" +str(calc1))
