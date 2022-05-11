def cal_sum(numbers):
     sum = 0
     for number in numbers:
         sum += number
     return sum

numberList = [10, 40, 60, 90]
result = cal_sum(numberList)

print("The sum of all the elements is:" + str(result))

