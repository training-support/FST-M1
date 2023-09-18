fruit = {
    "Guava": 20,
    "Papaya": 50,
    "Kiwi": 100,
    "Orange": 40,
}

check = input("Which fruit do you want? ")

if check in fruit:
    print("Yes, this fruit is available")
else:
    print("No, this fruit is not available")