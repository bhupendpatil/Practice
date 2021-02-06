import minimax_helpers

from gamestate import *

g = GameState()

print("Calling min_value on an empty board...")
v = minimax_helpers.min_value(g)

if v == -1:
    print("min_value() returned the expected score!")
else:
    print("Uh oh! min_value() did not return the expected score.")

"""
Output:

Calling min_value on an empty board...
Uh oh! min_value() did not return the expected score.
"""
