## Get the User name 
user1 = input ("What is the Player's 1 name ")
user2 = input ("What is the Player's 2 name ")

##Get the Users Choices
user1_answer = input(user1 + ", do you want to choose rock, paper or scissor ").lower()
user2_answer = input(user2 + ", do you want to choose rock, paper or scissor ").lower()

#Run the algorithm to see who wins
if user1_answer == user2_answer :
    print("It's a tie")
elif user1_answer == 'rock':
    if user2_answer == 'scissor':
        print("Rock wins!")
    else:
        print("Paper wins!")
elif user1_answer == 'scissor' :
    if user2_answer== 'paper' :
        print("Scisson wins!")
    else:
        print("Rocks wins!")
elif user1_answer == 'paper':
    if user2_answer== 'rock':
        print("Papaer wins")
    else:
        print("Scissor wins!")
else:
    print("Invalid input ! You have not entered rock, paper or scissor, try again")

