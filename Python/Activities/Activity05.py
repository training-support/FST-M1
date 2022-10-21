while True:
    number = int (input("Enter number : "))
    if number >10:
        print("Please enter valid input number from 1 to 10")
    else:
        for i in range(1,11):
            print(number, ' x ', i, ' = ', number * i)
        raise SystemExit
