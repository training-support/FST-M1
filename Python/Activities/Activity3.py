player1 = input("Player1 Enter your option: ")
player2 = input("Player2 Enter your option: ")

while True:
    if(player1.lower() == player2.lower()):
        print("Its a tie")
    elif(player1.lower() == "rock"):
        if(player2.lower() == "scissors"):
            print("Rock beates Scissors")
        else:
            print("Paper wins")
    elif(player1.lower() == "scissors"):
        if(player2.lower() == "paper"):
            print("Scissors beates Paper")
        else:
            print("Rock wins")
    elif(player1.lower() == "paper"):
        if(player2.lower() == "rock"):
            print("Paper beates rock")
        else:
            print("Scissors wins")
    elif((player1.lower() not in ("rock", "paper", "scissors")) and (player2.lower() not in ("rock", "paper", "scissors"))):
        print("Invalid option")


