def cal_sum(numbers):
    sum = 0
    for n in numbers:
        sum += n
    return sum


numList = [12, 45, 76, 34, 90]
result = cal_sum(numList)

print("The sum of all the elements in the list is: " + str(result))
