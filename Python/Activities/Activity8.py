lst = []
n = int(input("Enter number of elements : "))  
for i in range(0, n):
    ele = int(input())
    lst.append(ele)      
print(lst)
if lst[0]==lst[n-1]:
    print(True)
else:
    print(False)
    