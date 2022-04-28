Fruit_Dict = {
"mango" : 100,
"banana" : 50,
"watermelon" : 30
}

Fruit_Check = input("Is this fruit available??: ").lower()
 
if(Fruit_Check in Fruit_Dict):

    print(f"Yes, {Fruit_Check} is available")
else:
    print(f"No, {Fruit_Check} is not available")