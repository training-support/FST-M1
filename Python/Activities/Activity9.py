firstlist = [21, 24, 25, 61, 23]
secondlist = [10, 11, 22, 32, 13]

thirdlist = []
for i in firstlist:
    if(i%2 != 0):
        thirdlist.append(i)

for i in secondlist:
    if(i%2 == 0):
        thirdlist.append(i)

print("Resulted Final list is: ")
print(thirdlist)