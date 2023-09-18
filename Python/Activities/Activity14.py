def fibonacci(n):
    if n <= 1:
        return n
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)


digit = int(input("Enter how many fibonacci nos. you want to generate: "))
print("Fibonacci Sequence: ")
for i in range(digit):
    print(fibonacci(i))
