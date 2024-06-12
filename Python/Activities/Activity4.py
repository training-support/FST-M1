player1 = input("What is Player 1's name? ")
player2 = input("What is Player 2's name? ")
  
while True:
    choice1 = input(player1 + ", choose any one: rock, paper or scissors? ").lower()
    choice2 = input(player2 + ", choose any one: rock, paper or scissors? ").lower()
    if choice1 == choice2:
        print("It's a tie!")
    elif choice1 == 'rock':
        if choice2 == 'scissors':
            print(player1 + " wins")
        else:
            print(player2 + " wins")
    elif choice1 == 'scissors':
        if choice2 == 'paper':
            print(player1 + " wins")
        else:
            print(player2 + " wins")
    elif choice1 == 'paper':
        if choice2 == 'rock':
            print(player1 + " wins")
        else:
            print(player2 + " wins")
    else:
        print("Invalid input!")

    repeat = input("Do you want to continue? Yes/No: ").lower()
    
    if(repeat == "yes"):
        pass
    elif(repeat == "no"):
        raise SystemExit
    else:
        print("You entered an invalid option. Exiting now.")
        raise SystemExit