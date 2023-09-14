
"""
Based on examples from Sedgewick & Wayne, Intro to
Programming in Java / Python:
https://introcs.cs.princeton.edu/java/13flow/
https://introcs.cs.princeton.edu/python/13flow/
"""
__author__ = "Noah Barrall"

from sys import argv 
from random import random

if __name__ == "__main__": 

    stake = 10
    goal = 20
    trials = 1000

    if len(argv) >= 4: 
        stake = int(argv[1])
        goal = int(argv[2])
        trials = int(argv[3])

    bets = 0
    wins = 0    

    for i in range(trials):
        cash = stake
        while (cash > 0) and (cash < goal):
            bets += 1

            if random() < 0.5: 
                cash += 1
                if trials == 1:
                    print("$" * cash)
            else:
                cash -= 1
        if cash == goal:
            wins += 1
        
    print("{:4.1f}% wins".format(100 * wins / trials))
    print("Avg. bets: {:.1f}".format(bets / trials))