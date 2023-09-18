# Given lists
listOne = [18, 90, 23, 45, 89, 33, 56]
listTwo = [28, 4, 90, 59, 12, 45]

thirdList = []

for n in listOne:
    if (n % 2 != 0):
        thirdList.append(n)

for n in listTwo:
    if (n % 2 == 0):
        thirdList.append(n)

print("result of the new list is:")
print(thirdList)