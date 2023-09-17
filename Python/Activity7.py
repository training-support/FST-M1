NoOfList = int(input("How Many no you want to add in the list "))
ListOfData = []

for i in range(NoOfList):
    Data = input("Enter The Data in the list ")
    ListOfData.append(Data)
sum=0
for i in ListOfData:
    sum = sum + int(i)
print("The Sum Is " , sum)