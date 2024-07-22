user1 = input("What is player1's name?")
user2 = input("What is player2's name?")

user1_answer= input(user1+ " , Do you want to choose rock, paper or scissor?")
user2_answer= input(user2+ " , Do you want to choose rock, paper or scissor?")

if user1_answer == user2_answer:
    print("It's a tie")

elif user1_answer=="rock":
    if user2_answer=="scissor":
        print("Rock wins")
    else:
        print("Paper Wins")

elif user1_answer=="scissor":
    if user2_answer=="paper":
        print("Paper Wins")
    else:
        print("Rock Wins")

elif user1_answer=="paper":
    if user2_answer=="rock":
        print("Paper Wins")
    else:
        print("scissor Wins")

else:
    print("Invalid Input!Try again")

repeat = input("Do you want to play another round: ")
if(repeat == "yes"):
    pass

elif(repeat == "no"):
    raise SystemExit

else:
    print("You entered an invalid option. Exiting now.")
    raise SystemExit