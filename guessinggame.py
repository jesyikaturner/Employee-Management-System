''' Basic Guessing Game Code. User can continually play until quitting.
    + Maybe extend this to have a highscore of how little amount of guesses
    the user can guess the random number in.

    Jessica Turner. 2017.
'''

import random

def PrintMenu():
    print "Welcome to a Guessing Game!"
    print "\tA. Start a Game"
    # High Score?
    print "\tB. Quit"

''' Doing some basic error checking for the guessing.
    Basically makes sure what's entered will be converted to an int.'''
def TakeAGuess():
    while(True):
        guess = raw_input("Take a guess! ")
        if len(guess.split()) == 0:
            print "invalid character"
        try:
            guess = int(guess)
            break
        except ValueError:
            print "Number not entered."
    return guess

def Game(name, randInt):
    guesses = 0
    randomNumber = randInt

    while(True):
        guess = TakeAGuess()
        guesses += 1
        if guess == randomNumber or guesses > 6:
            break
        if guess < randomNumber:
            print "Your guess is too small."
        if guess > randomNumber:
            print "Your guess is too big."
    if guess == randomNumber:
        print "Congratz "+name+" you got it right in " +str(guesses) +" guesses!"
    if guess != randomNumber:
        print "Sorry, the number I was thinking of was "+str(randomNumber)+"."

''' Program will continue executing until the user quits. '''
def main():
    name = ""
    while(True):
        PrintMenu()
        choice = raw_input("Please choose an option: ")
        if choice == "A" or choice == "a":
            randomNumber = random.randint(1,20)
            if len(name) < 1:
                name =  raw_input("Hello, what's your name? ")
            print "Well, "+name+", I am thinking of a number between 1 and 20."
            Game(name, randomNumber)

        if choice == "B" or choice == "b":
            break

if __name__ == "__main__":
    main()
