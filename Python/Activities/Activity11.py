	
fruit_shop = {
    "pineapple": 60,
	"banana": 65,
    "orange": 70,
    "guava": 55	
}
	

search_term = input("What are you looking for?: ").lower()
		
if(search_term in fruit_shop):
	
    print(search_term  + " costs "  +  str(fruit_shop[search_term])  +  " rupees")
	
else:
	
    print("Fruits out of stock")