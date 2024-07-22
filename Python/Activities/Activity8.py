numlist = list(input("Enter a sequence of comma separated values: ").split(", "))
print("Entered list is: ", numlist)

if(numlist[0]==numlist[-1]):
    print(True)
else:
    print(False)