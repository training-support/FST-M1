shop = {
    "Mango": 10,
    "Apple": 15,
    "orange": 8,
    "Watermelon": 15
}

fruitName= input("Which fruit are you looking for? ")

if(fruitName in shop):
    print(fruitName," This fruit is available")
else:
    print(fruitName,"this Fruit is not available")