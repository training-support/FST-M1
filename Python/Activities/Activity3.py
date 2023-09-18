
player1 = input("Enter player1's name ")
player2 = input("Enter Player 2's name ")

player1_answer = input(player1 + " choose anyone out of rock, paper, scissor").lower()
player2_answer = input(player2 + " choose anyone out of rock, paper, scissor ").lower()

if player1_answer == player2_answer:
    print("It's a tie!")
elif player1_answer == 'rock':
    if player2_answer == 'scissors':
        print(player1 + "wins!")
    else:
        print(player2 + "wins!")
elif player1_answer == 'scissors':
    if player2_answer == 'paper':
        print(player1 + "win!")
    else:
        print(player2 + "wins!")
elif player1_answer == 'paper':
    if player2_answer == 'rock':
        print(player1 + "wins!")
    else:
        print(player2 + "win!")
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")