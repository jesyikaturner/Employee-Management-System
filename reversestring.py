# Takes the string input and splits it up into an array
def TurnStringToArray(inputString):
    wordsArray = inputString.split()
    return wordsArray

# Takes the array input and reverses the order of the words
def ReverseArray(inputArray):
    reverseWordsArray = ["" for x in range(len(inputArray))]
    for i in range (0,len(inputArray)):
        reverseWordsArray[len(inputArray)-1-i] = inputArray[i]
    return reverseWordsArray

def TurnArrayToString(inputArray):
    newString = ""
    for i in range(0,len(inputArray)):
        newString += inputArray[i] + " "
    return newString

# Reverses the sentence word by word
def ReverseWordByWord(inputString):
    words = TurnStringToArray(inputString)
    array = ReverseArray(words)
    newWords = TurnArrayToString(array)
    return newWords

# Reverses the sentence letter by letter
def ReverseWholeSentence(inputString):
    newString = ""
    slist = list(inputString)
    for i in range (0,len(inputString)):
        newString += slist[len(slist) - 1 - i]
    return newString

# Very basic input handling XD Basically no error checking.
def main():
    running = bool(1)
    print "This program reverses your sentence!\n"
    print "a - Reverse by words.\n"
    print "b - Reverse by letters.\n"
    print "c - Quit. \n"
    string = raw_input("Please enter your sentence: ")

    while(running):
        choice = raw_input("Please enter your choice: ")
        if choice == "a":
            output = ReverseWordByWord(string)
            print output
        elif choice == "b":
            output = ReverseWholeSentence(string)
            print output
        elif choice == "c":
            running = bool(0)
        else:
            print "Wrong input!"


# main method
main()
