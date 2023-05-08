def calculate_sum(numbers):
    sum = 0
    for number in numbers:
        sum += int(number)
    return sum


list1 = input("Enter a sequence of comma and space separated values: Ex.1, 2, 3 -").split(", ")
print(list1)

result = calculate_sum(list1)
print("The sum: " + str(result))
