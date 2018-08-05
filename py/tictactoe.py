'''
    Basic Tic-Tac-Toe game. Only handles drawing atm.
    Going to work on win condition soon. Then going to work on Computer AI.
    Will extend to file handling with a high score + remembered name.

    Jessica Turner. 2017.
'''

import random

'''
    HANDLING BOARD
'''
# Draw the Current Board
def DrawBoard(board):
    print(''+board[7]+'|'+board[8]+'|'+board[9])
    print('-------')
    print(''+board[4]+'|'+board[5]+'|'+board[6])
    print('-------')
    print(''+board[1]+'|'+board[2]+'|'+board[3])
    print('')

# Check if board position is free
def IsSpaceFree(board, move):
    return board[move] == ' '

def IsBoardFull(board):
    for i in range (1, 10):
        if IsSpaceFree(board, i):
            return False
    return True

'''
 HANDLING PLAYER MOVES
'''
# Choose Token to play with
def InputToken():
    letter = ''
    while not (letter == 'X' or letter == 'O'):
        letter = raw_input('Pick X or O as your token: ')
        letter = letter.upper()
    if letter == 'X':
        return ['X','O']
    else:
        return ['O','X']
   
# Determine who goes first
def StartingPlayer():
    if random.randint(0,1) == 0:
        return 'computer'
    else:
        return 'player'

# Places token on board
def MakeMove(board, token, place):
    board[place] = token

# Getting player move
def GetPlayerMove(board):
    move = ''
    while move not in '1 2 3 4 5 6 7 8 9'.split() or not IsSpaceFree(board, int(move)):
        move = raw_input('What is your move? (1 -> 9)')
    return int(move)

# Getting computer move
def GetComputerMove(board):
    move = -1
    while not IsSpaceFree(board, int(move)):
        move = random.randint(1,9)
    return move

'''
    GAME LOGIC
''' 
def main():
    print ('Welcome to Tic-Tac-Toe')
    currentBoard = [' '] * 10
    playerToken, computerToken = InputToken()
    turn = StartingPlayer()
    print ('The '+turn+' will go first.')

    while(True):
        print('It is the '+turn+' turn now.')
        DrawBoard(currentBoard)
        if IsBoardFull(currentBoard):
            print('The game is a tie!')
            break
        if turn == 'player':
            move = GetPlayerMove(currentBoard)
            MakeMove(currentBoard, playerToken, move)
            turn = 'computer'
        else:
            move = GetComputerMove(currentBoard)
            MakeMove(currentBoard, computerToken, move)
            turn = 'player'
        
if __name__ == "__main__":
    main()            
        
