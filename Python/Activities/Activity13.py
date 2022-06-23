def sum(*num):
    sum=0
    for numbers in num:
      sum+=numbers
      
    return sum


a= sum(2,3,4,10)

print("The sum of all numbers passed",a)