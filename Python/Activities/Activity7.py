numbers = list(input("Enter the numbers you want the sum for: ").split(", "))
sum = 0

for number in numbers:
    sum += int(number)

print("The sum of the numbers in the list: ", sum)

