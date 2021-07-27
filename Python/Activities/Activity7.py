numbers = list(input("Enter a sequence of comma separated values: ").split(", "))
sum = 0
 
for i in numbers:
  sum += int(i)
 
print(sum)