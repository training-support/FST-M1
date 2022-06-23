num=int(input("Enter the positive number for fibonacci series: "))


def fibonacci(number):
  if (number <=1):
    return number
  else:
      return (fibonacci(number-1) + fibonacci(number-2))

if (num <=0):
    print("Enter number greater than 1")
else:
    print("The sequence of the series")
    for x in range(num):
     print(fibonacci(x))