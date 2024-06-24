# Custom function to calculate sum
def calculate_sum(numbers):
    sum = 0
    for number in numbers:
        sum += number
    return sum

# Define the list of numbers
numList = [10, 40, 60, 90]

# Call the sum() function with numList as argument
result = calculate_sum(numList)

# Print result with message
print("The sum of all the elements is: " + str(result))