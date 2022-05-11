listOne = [10, 20, 23, 11, 17]
listTwo = [13, 43, 24, 36, 12]
print("First List ", listOne)
print("Second List ", listTwo)
thirdList = []
for num in listOne:
    if (num % 2 != 0):
        thirdList.append(num)
for num in listTwo:
    if (num % 2 == 0):
        thirdList.append(num)
print("result List is:")
print(thirdList)