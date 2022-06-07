listA = [10, 20, 23, 11, 17]
listB = [13, 43, 24, 36, 12]

# Print the lists
print("First List ", listA)
print("Second List ", listB)

# Declare a third list that will contain the result
thirdList = []

# Iterate through first list to get odd elements
for num in listA:
    if (num % 2 != 0):
        thirdList.append(num)
        
# Iterate through first list to get even elements
for num in listB:
    if (num % 2 == 0):
        thirdList.append(num)

# Print result
print("result List is:")
print(thirdList)