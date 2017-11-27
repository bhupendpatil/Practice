"""
Almost everyone in the world knows about the ancient game Chess and has at
least a basic understanding of its rules. It has various units with a wide
range of movement patterns allowing for a huge number of possible different
game positions (for example Number of possible chess games at the end of the
n-th plies.) For this mission, we will examine the movements and behavior of
chess pawns.

Chess is a two-player strategy game played on a checkered game board laid out
in eight rows (called ranks and denoted with numbers 1 to 8) and eight
columns (called files and denoted with letters a to h) of squares. Each
square of the chessboard is identified by a unique coordinate pair — a
letter and a number (ex, "a1", "h8", "d6"). For this mission we only need
to concern ourselves with pawns. A pawn may capture an opponent's piece on
a square diagonally in front of it on an adjacent file, by moving to that
square. For white pawns the front squares are squares with greater row than
their.

A pawn is generally a weak unit, but we have 8 of them which we can use to
build a pawn defense wall. With this strategy, one pawn defends the others.
A pawn is safe if another pawn can capture a unit on that square. We have
several white pawns on the chess board and only white pawns. You should design
your code to find how many pawns are safe.

pawns

You are given a set of square coordinates where we have placed white pawns.
You should count how many pawns are safe.

Input: Placed pawns coordinates as a set of strings.

Output: The number of safe pawns as a integer.

Example:

safe_pawns({"b4", "d4", "f4", "c3", "e3", "g5", "d2"}) == 6
safe_pawns({"b4", "c4", "d4", "e4", "f4", "g4", "e5"}) == 1
1
2

How it is used: For a game AI one of the important tasks is the
ability to estimate game state. This concept will show how you can
do this on the simple chess figures positions.

Precondition:
0 < pawns ≤ 8

"""

def safe_pawns(pawns):
    def get_coord(a):
        return ord(a[0])-96, int(a[1])

    def defend_coord(x, y):
        defend = []
        if (x+1 <= 8) and (y+1 <= 8):
            defend.append([x+1, y+1])
        if (x-1 <= 8) and (y+1 <= 8):
            defend.append([x-1, y+1])
        return defend

    board = [[0 for j in range(9)] for i in range(9)]
    pawns, ans = list(pawns), 0

    for pawn in pawns:
        for pwn in defend_coord(*get_coord(pawn)):
            board[pwn[0]][pwn[1]] = 1

    for pawn in pawns:
        ans += board[get_coord(pawn)[0]][get_coord(pawn)[1]]
    return ans


def test_function():
    assert safe_pawns({"b4", "d4", "f4", "c3", "e3", "g5", "d2"}) == 6
    assert safe_pawns({"b4", "c4", "d4", "e4", "f4", "g4", "e5"}) == 1
    assert safe_pawns({"e8"}) == 0
