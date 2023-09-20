def sum_cal(number):
    sum = 0
    for numbers in number:
        sum += numbers
    return sum
numList = [10,40,60,80]
result = sum_cal(numList)
print("the sum of all elements:" + str(result))
