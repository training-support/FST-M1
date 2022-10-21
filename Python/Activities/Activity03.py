player1 = input("Enter first player name : ")
player2 = input("Enter second player name : ")
if player1 == player2:
    print("Invalid player selection, please try again")
else:
    player1_Ans = input(player1 + " Do you want to choose Rock, Paper or Scissors? ").lower()
    player2_Ans = input(player2 + " Do you want to choose Rock, Paper or Scissors? ").lower()

    if player1_Ans == player2_Ans:
        print("It's a tie")
    elif player1_Ans == 'rock':
        if player2_Ans == 'scissors':
            print("Rock Paper")
        else:
            print("Paper wins")
    elif player1_Ans == 'scissors':
         if player2_Ans != 'paper':
             print("Rock wins")
         else:
             print("Scissors wins")
    elif player1_Ans == 'paper':
        if player2_Ans == 'rock':
            print("Paper wins")
        else:
            print("Scissors wins")
    else:
        print("Invalid input please try again")