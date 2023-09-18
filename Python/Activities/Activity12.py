def calSum(num):
    if num:
        return num + calSum(num-1)
    else:
        return 0
result = calSum(10)

# Print result
print(result)