"""
Based on examples from Sedgewick & Wayne, Intro to
Programming in Java / Python.
https://introcs.cs.princeton.edu/java/14array/
https://introcs.cs.princeton.edu/python/14array/
"""
__author__ = "David Owen and Noah Barrall"

from sys import argv
from random import randrange

if __name__ == "__main__":

    n = 100
    trials = 1000
    totalTries = 0

    if len(argv) >= 3: 
        n = int(argv[1])
        trials = int(argv[2])

    for i in range(trials):
        isCollected = [False] * n
# Make an n-length list of False values.
        tries = 0
        numCollected = 0

        while numCollected < n:
            tries += 1
            r = randrange(n)

            if not isCollected[r]:
# Same as "if isCollected[r] == False:"
                numCollected += 1
                isCollected[r] = True
                
        totalTries += tries

print("Average tries to collect 10 coupons: {:.2f}".format(totalTries/trials))