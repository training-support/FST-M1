#User inputs
firstuser=input("What is first user name")
seconduser=input("What is second user name")

#Get the user choice 
firstUserChoice=input(firstuser+",do you want to choose Rock,paper or Scissors ?").lower()
secondUserChoice=input(seconduser+",do you want to choose Rock, paper or Scissors ?").lower()

if firstUserChoice==secondUserChoice:
    print("Game is tie")
elif firstUserChoice=='Rock':
    if secondUserChoice=='Scissors':
       print("Rock win")
    else:
       print("Paper wins")
elif firstUserChoice=='Scissors':
    if secondUserChoice=='paper':
       print("scissors win")
    else:
        print("Rock wins")
elif firstUserChoice=='paper':
    if secondUserChoice=='Rock':
       print("Paper wins")
    else:
        print("Scissors win")
else:
    print("User has not entered any choice, please enter the choice")   