fruit_shop = {
    "apple": 10,
    "banana": 15,
    "oranges":8,
    "peaches":12
}

key_to_check = input("What are you looking for:")

if(key_to_check in fruit_shop):
    print("Yes, this is available")

else:
    print("No, this is not available")
