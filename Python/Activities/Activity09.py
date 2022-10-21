fistList = [1,5,8,9,4,6]
secondList = [13,14,24,26,37,38]
print("Given the Fist List", fistList)
print("Given the Second List", secondList)

thirdList = []
for num in fistList:
    if num % 2 !=0:
        thirdList.append(num)

for num in secondList:
    if num % 2 == 0:
        thirdList.append(num)

print("New List is which contain odd from First list and Even from second list :", thirdList)