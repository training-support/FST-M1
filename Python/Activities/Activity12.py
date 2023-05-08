def calsum(num):
    if num:
        return num + calsum(num - 1)
    else:
        return 0


res = calsum(10)
print(res)
