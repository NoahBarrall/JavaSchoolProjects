
from random import randrange

def takeTurn(holdAmount):
    turnScore = 0

    while turnScore < holdAmount:
        rollScore = randrange(1, 7)
        
        if rollScore > 1:
            turnScore += rollScore
        else:
            turnScore = 0
            break
    return turnScore

def takeTurnInteractive():
    turnScore = 0

    while True:
        rollScore = randrange(1, 7)

        if rollScore > 1:
            turnScore += rollScore

            print("You rolled {}".format(rollScore))
            print("Your score for this turn is {}".format(turnScore))

            inputLine = input("Roll again? (Y/N): ")
            inputCaps = inputLine.upper()
            firstChar = inputLine[0]

            if firstChar == "N": break

        else:
            turnScore = 0
            print("You rolled a PIG!")
            print("Your score for the turn is 0")
            break;
    return turnScore
