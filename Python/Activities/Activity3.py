choice1 = input("Player 1- please choose rock, paper or scissors? ").lower()
choice2 = input("Player 2- please choose rock, paper or scissors? ").lower()

if choice1 == choice2:
    print("It's a tie!")
elif choice1 == 'rock':
    if choice2 == 'scissors':
        print("Player 1 wins!")
    else:
        print("Player 2 wins!")
elif choice1 == 'scissors':
    if choice2 == 'paper':
        print("Player 1 wins!")
    else:
        print("Player 2 wins!")
elif choice1 == 'paper':
    if choice2 == 'rock':
        print("Player 1 wins!")
    else:
        print("Player 2 wins!")
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")