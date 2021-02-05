xlim,ylim=3,2
class GameState:
    def __init__(self):
        self._board = [[0]*ylim for _ in range(xlim)]
        self._board[-1][-1] = 1
        self._parity = 0
        self._player_locations = [None,None]

if __name__ == "__main__":
    emptyState = GameState()
