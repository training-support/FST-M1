##Write a program that asks the user how many Fibonnaci numbers to generate and then generates them.
def fibonacci(number):
    if number <= 1:
        return number
    else:
        return(fibonacci(number-1) + fibonacci(number-2))
 
nterms = int(input("Enter a number: "))
 
if nterms <= 0:
    print("Please enter a positive number")
else:
    print("Fibonacci Sequence: ")
    for i in range(nterms):
        print(fibonacci(i))