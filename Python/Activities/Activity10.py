numbers = input("Enter a sequence of comma and space separated values: Ex.1, 2, 3").split(", ")
print(numbers)

print("Elements that are divisible by 5:")
for num in numbers:
    if int(num) % 5 == 0:
        print(num)
