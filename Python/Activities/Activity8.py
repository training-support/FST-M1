numbers = input("Enter a sequence of comma and space separated values: Ex.1, 2, 3").split(", ")
print(numbers)

firstElement = numbers[0]
print(firstElement)
lastElement = numbers[-1]
print(lastElement)

if firstElement == lastElement:
    print(True)
else:
    print(False)
