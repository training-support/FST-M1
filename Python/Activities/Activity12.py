def sumofNumbers(num):
    if num:
        return num + sumofNumbers(num-1)
    else:
        return 0

calRecursiveSum = sumofNumbers(25)
print(calRecursiveSum)