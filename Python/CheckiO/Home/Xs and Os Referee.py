"""

Tic-Tac-Toe, sometimes also known as Xs and Os, is a game for two players (X and O) who take turns marking the spaces in a 3×3 grid.
The player who succeeds in placing three respective marks in a horizontal, vertical, or diagonal rows (NW-SE and NE-SW) wins the game.

But we will not be playing this game. You will be the referee for this games results. You are given a result of a game and you 
must determine if the game ends in a win or a draw as well as who will be the winner. Make sure to return "X" if the X-player wins 
and "O" if the O-player wins. If the game is a draw, return "D".

x-o-referee

A game's result is presented as a list of strings, where "X" and "O" are players' marks and "." is the empty cell.

Input: A game result as a list of strings (unicode).

Output: "X", "O" or "D" as a string.

Example:

checkio([
    "X.O",
    "XX.",
    "XOO"]) == "X"
checkio([
    "OO.",
    "XOX",
    "XOX"]) == "O"
checkio([
    "OOX",
    "XXO",
    "OXX"]) == "D"
1
2
3
4
5
6
7
8
9
10
11
12
How it is used: The concepts in this task will help you when iterating data types. They can also be used in game algorithms, allowing
you to know how to check results.

"""

def checkio(game_result):
    z = game_result

    a = z[0]
    b = z[1]
    c = z[2]

    p = []
    q = []
    r = []

    for i in a:
        p.append(i)

    for j in b:
        q.append(j)

    for k in c:
        r.append(k)

    #X
    #Horizontal
    if (p[0]=="X" and p[1]=="X" and p[2]=="X") or (q[0]=="X" and q[1]=="X" and q[2]=="X") or (r[0]=="X" and r[1]=="X" and r[2]=="X"):
        return("X")
    #Vertical
    elif (p[0]=="X" and q[0]=="X" and r[0]=="X") or (p[1]=="X" and q[1]=="X" and r[1]=="X") or (p[2]=="X" and q[2]=="X" and r[2]=="X"):
        return("X")
    #Diagonal
    elif (p[0]=="X" and q[1]=="X" and r[2]=="X") or (p[2]=="X" and q[1]=="X" and r[0]=="X"):
        return("X")
    

    #O
    #Horizontal
    elif (p[0]=="O" and p[1]=="O" and p[2]=="O") or (q[0]=="O" and q[1]=="O" and q[2]=="O") or (r[0]=="O" and r[1]=="O" and r[2]=="O"):
        return("O")
    #Vertical
    elif (p[0]=="O" and q[0]=="O" and r[0]=="O") or (p[1]=="O" and q[1]=="O" and r[1]=="O") or (p[2]=="O" and q[2]=="O" and r[2]=="O"):
        return("O")
    #Diagonal
    elif (p[0]=="O" and q[1]=="O" and r[2]=="O") or (p[2]=="O" and q[1]=="O" and r[0]=="O"):
        return("O")

    #D
    else:
        return("D")

if __name__ == '__main__':
    #These "asserts" using only for self-checking and not necessary for auto-testing
    assert checkio([
        "X.O",
        "XX.",
        "XOO"]) == "X", "Xs wins"
    assert checkio([
        "OO.",
        "XOX",
        "XOX"]) == "O", "Os wins"
    assert checkio([
        "OOX",
        "XXO",
        "OXX"]) == "D", "Draw"
    assert checkio([
        "O.X",
        "XX.",
        "XOO"]) == "X", "Xs wins again"

