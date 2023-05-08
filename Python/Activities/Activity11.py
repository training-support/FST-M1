fruit_Dict = {
    "mango": 1,
    "banana": 2,
    "watermelon": 3,
    "pear": 4,
    "guava": 5
}

print("Available Fruits: ", fruit_Dict)
fruit = input("Which Fruit you want: ").lower()

if fruit in fruit_Dict:
    print("Yes, this is available")
else:
    print("No, this is not available")