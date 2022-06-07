#numbers = list(input("Enter a sequence of comma separated values: ").split(", "))
numbers = list(("17", "21", "35"))
print(numbers)
sum = 0
for number in numbers:
  sum += int(number)

print(sum)