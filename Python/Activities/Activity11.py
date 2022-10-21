fruit_shop = {"apple", 20,
              "banana", 15,
              "orange", 35,
              "mango", 45
              }
key_to_Check = input("Which fruit you want :").lower()
if key_to_Check in fruit_shop:
    print("Yes, this fruit is available")
else:
    print("No, this fruit is Not available")
