from copy import deepcopy

xlim,ylim=3,2
class GameState:
    def __init__(self):
        self._board = [[0]*ylim for _ in range(xlim)]
        self._board[-1][-1] = 1
        self._parity = 0
        self._player_locations = [None,None]
        
    def get_legal_moves(self):
        """ Return a list of all legal moves available to the
        active player.  Each player should get a list of all
        empty spaces on the board on their first move, and
        otherwise they should get a list of all open spaces
        in a straight line along any row, column or diagonal
        from their current position. (Players CANNOT move
        through obstacles or blocked squares.) Moves should
        be a pair of integers in (column, row) order specifying
        the zero-indexed coordinates on the board.
        """
        # TODO: implement this function!
        loc = self._player_locations[self._parity]
        if not loc:
            return [(x,y) for y in range(ylim) for x in range(xlim) if self._board[x][y]==0]
        moves = []
        rays = [(1, 0), (1, -1), (0, -1), (-1, -1),(-1, 0), (-1, 1), (0, 1), (1, 1)]
        for dx,dy in rays:
            _x,_y = loc
            while 0 <= _x+dx < xlim and 0 <= _y+dx < ylim:
                _x,_y = _x+dx, _y+dy
                if self._board[_x][_y]:
                    break
                moves.append((_x,_y))
        return moves

    def forecast_move(self, move):
        """ Return a new board object with the specified move
        applied to the current game state.
        
        Parameters
        ----------
        move: tuple
            The target position for the active player's next move
            (e.g., (0, 0) if the active player will move to the
            top-left corner of the board)
        """
        # TODO: implement this function!
        if move not in self.get_legal_moves():
            raise RuntimeError("Illegal move attempt")
        newBoard = deepcopy(self)
        newBoard._board[move[0]][move[1]]=1
        newBoard._player_locations[self._parity]
        newBoard._parity ^= 1
        return newBoard

if __name__ == "__main__":
    emptyState = GameState()
