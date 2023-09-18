numlist = list(input("Enter the numbers ").split(", "))
print("Given list is ", numlist)

# Get first element in list
firstElement = numlist[0]
# Get last element in list
lastElement = numlist[-1]

if (firstElement == lastElement):
    print(True)
else:
    print(False)