from sys import argv
import pig_functions

if __name__ == "__main__":
    computerHoldAmt = int(argv[1])
    computerScore = 0
    userScore = 0

    roundCount = 1

    while computerScore < 100 and userScore < 100:
        print("\nRound {} - Computer: {}, User: {}".format(
            roundCount, computerScore, userScore))
        print("-----------------------------------")

        turnScore = pig_functions.takeTurn(computerHoldAmt)
        computerScore += turnScore
        print("The computer scored {}".format(turnScore))
        print("Now it’s your turn ...\n")

        turnScore = pig_functions.takeTurnInteractive()
        userScore += turnScore

        roundCount += 1
        
    if computerScore > userScore:
        print("\nYou lose, {} to {}. Sorry!\n".format(
    computerScore, userScore))
    elif userScore > computerScore:
        print("\nYou win, {} to {}!!\n".format(
        userScore, computerScore))
    else:
        print("\nIt’s a tie, {} to {}.\n".format(
        userScore, computerScore))
    