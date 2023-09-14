"""
Coupon collector example modified to simulate the dice
game "Cootie."
https://en.wikipedia.org/wiki/The_Game_of_Cootie
"""
__author__ = "David Owen and Noah Barrall"

from sys import argv
from random import randrange

if __name__ == "__main__":
    trials = 1000
    totalTries = 0

    if len(argv) >= 2: 
        trials = int(argv[1])

    for i in range(trials):
        tries = 0
    
    # body
        while True:
            tries += 1

            if randrange(1, 7) == 1:
                break

                # head
        while True:
            tries += 1

            if randrange(1, 7) == 2:
                break

        # 1 headgear, 1 pair of eyes, 1 tongue, 6 feet
        partsNeeded = [1, 1, 1, 6]
        numNeeded = sum(partsNeeded)
        partsCollected = [0] * 4
        numCollected = 0

        while numCollected < numNeeded:
            tries += 1
            r = randrange(1, 7)

            if r >= 3:
                i = r - 3

                if partsCollected[i] < partsNeeded[i]:
                    numCollected += 1
                    partsCollected[i] += 1
            
        totalTries += tries

    average_tries = totalTries/trials
    print("The average number of tries was: {:.2f}".format(average_tries))