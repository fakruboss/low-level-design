package fakru.lld.tictactoe;

import fakru.lld.tictactoe.exceptions.InvalidPositionException;
import java.util.ArrayList;
import java.util.List;

public class Game {

  private final Board board;
  private final List<Move> availableMoves;

  public Game() {
    board = new Board();
    availableMoves = generateAllMoves();
  }

  public Board getBoard() {
    return board;
  }

  public List<Move> getAvailableMoves() {
    return availableMoves;
  }

  private List<Move> generateAllMoves() {
    List<Move> allPossibleMoves = new ArrayList<>();
    for (int i = 1; i <= this.getBoard().getBoardLength(); ++i) {
      for (int j = 1; j <= this.getBoard().getBoardHeight(); ++j) {
        allPossibleMoves.add(new Move(i, j));
      }
    }
    return allPossibleMoves;
  }

  public void removeUtilisedMove(Move move) {
    this.getAvailableMoves().remove(move);
  }

  public boolean undoPreviousMove(List<Move> moves) {
    int previousMoveIndex = moves.size() - 1;
    Move previousMove = moves.get(previousMoveIndex);
    this.getBoard().setPositionalValue(previousMove.getX(), previousMove.getY(), '*');
    this.getAvailableMoves().add(previousMove);
    return moves.remove(previousMove);
  }

  public boolean makeMove(Player p, Move move) {
    if (move.getX() <= 0 || move.getX() > this.getBoard().getBoardLength()) {
      throw new InvalidPositionException("invalid position lengthwise");
    }
    if (move.getY() <= 0 || move.getY() > this.getBoard().getBoardHeight()) {
      throw new InvalidPositionException("invalid position height wise");
    }
    if (this.getBoard().getPositionalValue(move.getX(), move.getY()) != '*') {
      throw new InvalidPositionException("position already filled");
    }
    this.getBoard().setPositionalValue(move.getX(), move.getY(), p.getSymbol());
    return true;
  }

  public boolean isGameOver(Move m) {
    return isVerticalStrike(m.getX()) || isHorizontalStrike(m.getY()) || isDiagonalStrike();
  }

  private boolean isVerticalStrike(int x) {
    char master = this.getBoard().getPositionalValue(x, 1);
    if (master == '*') {
      return false;
    }
    for (int i = 1; i <= this.getBoard().getBoardHeight(); ++i) {
      if (this.getBoard().getPositionalValue(x, i) != master) {
        return false;
      }
    }
    return true;
  }

  private boolean isHorizontalStrike(int y) {
    char master = this.getBoard().getPositionalValue(1, y);
    if (master == '*') {
      return false;
    }
    for (int i = 1; i <= this.getBoard().getBoardLength(); ++i) {
      if (this.getBoard().getPositionalValue(i, y) != master) {
        return false;
      }
    }
    return true;
  }

  private boolean isDiagonalStrike() {
    int boardLength = this.getBoard().getBoardLength();
    int boardHeight = this.getBoard().getBoardHeight();
    if (boardLength != boardHeight) {
      return false;
    }
    return isLeftToRightDiagonalStrike() || isRightToLeftDiagonalStrike();
  }

  private boolean isLeftToRightDiagonalStrike() {
    int boardLength = this.getBoard().getBoardLength();
    char master = this.getBoard().getPositionalValue(1, 1);
    if (master == '*') {
      return false;
    }
    boolean isDiagonalStrike = true;
    for (int i = 1; i <= boardLength; ++i) {
      if (this.getBoard().getPositionalValue(i, i) != master) {
        isDiagonalStrike = false;
      }
    }
    return isDiagonalStrike;
  }

  private boolean isRightToLeftDiagonalStrike() {
    int boardLength = this.getBoard().getBoardLength();
    int boardHeight = this.getBoard().getBoardHeight();
    char master = this.getBoard().getPositionalValue(1, 1);
    if (master == '*') {
      return false;
    }
    boolean isDiagonalStrike = true;
    for (int i = 1, j = boardHeight; i <= boardLength; ++i, --j) {
      if (this.getBoard().getPositionalValue(i, j) != master) {
        isDiagonalStrike = false;
      }
    }
    return isDiagonalStrike;
  }
}