Player1 = input("enter player1 name")
Player2 = input("enter player2 name")

while True:
    Player1_answer = input (Player1 +",do wants to play rock,paper or scissors?").lower()
    Player2_answer = input (Player2 +",do wants to play rock,paper or scissors?").lower()

    if Player1_answer == Player2_answer:
        print("Its is a tie")
    elif Player1_answer =='rock':
        if Player2_answer == 'scissors':
            print('Player1  wins the game')
        else:
            print('Player2 wins the game ')
    elif Player1_answer == 'scissors':
        if Player2_answer == 'paper':
            print("scissor wins the game")
        else:
            print("paper wins the game")
    elif Player1_answer == 'paper':
        if Player2_answer == 'rock':
            print("paper wins the game")
        else:
            print("rock wins the game")
    else:
        print("invalid input from the player he is not entered above three options")

