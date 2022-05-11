fruit_shop={ 
    "apple": 20, 
    "kiwi": 40, 
    "banana": 25
}

searchFruit=input("Which fruit you want to buy:? ").lower()

if(searchFruit in fruit_shop):
    print("Yes this fruit is available")
else:
    print("No this fruit is not available")



#fruit_shop = {
 #   "apple": 10,
  #  "banana": 15,
   # "orange": 8,
    #"peaches": 15
#}

#key_to_check = input("What are you looking for? ").lower()

#if(key_to_check in fruit_shop):
 #   print("Yes, this is available")
#else:
 #   print("No, this is not available")
