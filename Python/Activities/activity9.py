list1 = [10,20,30,50,90,13]
list2 = [13,17,19,100]
print("firstlsit", list1)
print("secondlist", list2)

list3=[]

for num in list1:
    if(num % 2==0):
        list3.append(num)
for num in list2:
    if (num % 2 != 0):
        list3.append(num)
print("The result of the list:")
print(list3)



