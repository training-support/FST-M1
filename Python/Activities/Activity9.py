	
# Given lists
listOne = [10, 20, 23, 11, 17]
listTwo = [13, 43, 24, 36, 12]

# Print the lists
print("First List is:", listOne)
print("Second List is:", listTwo)

	
thirdList = []

for num in listOne:
   if(num % 2 !=0):
      thirdList.append(num)
for num in listTwo:
    if(num % 2 ==0):
        thirdList.append(num)

print("The third list items are :", thirdList)

