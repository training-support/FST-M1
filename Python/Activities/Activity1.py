
#Write a program that asks the user to enter their name and their age.
name = input("Enter  your name :")
age  = int (input("Enter your age :"))

#Print out a message addressed to them that tells them the year that they will turn 100 years old.
result =name + ", you will turn 100 in {}".format((2025-age) + 100)
print(result)