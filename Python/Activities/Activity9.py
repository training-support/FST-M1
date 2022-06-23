from ast import For


Num= list(input("Enter the elements for First List ").split(","))
Num2=list(input("Enter the elements for Second List ").split(","))

print("The list1 numbers " ,Num)
print("The list2 numbers " ,Num2)
FinalList=[]

for i in Num:
  if (int(i) % 2 != 0):
   FinalList.append(i)

for j in Num2:  
  if (int(j) % 2 ==0):
   FinalList.append(j)

print("The final list with even,odd number", FinalList)  

