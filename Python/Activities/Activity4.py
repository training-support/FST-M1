Player1 =input ("Enter player1 name :")
Player2 =input ("Enter player2 name :")

while True:
     Choice1 =input("player1 please choose from Rock,Paper,Scissor :")
     choice2 =input("player2 please choose from Rock,Paper,Scissor :")
if Choice1==choice2 :
    print("The Game is a tie.")
elif Choice1=='Rock' and choice2=='Scissor':
     print(Player1+" Player1 wins.")
elif Choice1=='Rock' and choice2=='Paper':
     print (Player2 +" Player2 wins.")
elif Choice1=='Scissor' and choice2=='Rock':
     print(Player2 +" Player2 wins")
elif Choice1=='Scissor' and choice2=='Paper' :   
       print(Player1+" Player1 wins")     
elif Choice1=='Paper' and choice2=='Rock' :   
       print(Player1+" Player1 wins")     
elif Choice1=='Paper' and choice2=='Scissor' :   
        print(Player1+" Player1 wins") 
else :
    print("Either of the user entered invalid choice.")
    
    repeat = input("Do you want to Continue? Yes/No: ").lower()
    if(repeat == "yes"):
        pass
    elif(repeat == "no"):
        raise SystemExit
    else:
        print("You entered an invalid option. Exiting now.")
        raise SystemExit






