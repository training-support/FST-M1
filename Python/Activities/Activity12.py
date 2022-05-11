#define function to calculate sum
def cal_sum(number):
    if number:
        return number + cal_sum(number-1)
    else:
        return 0
res = cal_sum(10)

print(res)