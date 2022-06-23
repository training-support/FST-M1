Num= tuple(input("Enter the elements for First List ").split(","))
print("The tuple list is",tuple)

FinalTuple =()

for i in Num:
    if(int(i) % 5==0):
         print("The number is divisble by 5",i)
