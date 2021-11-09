package fakru.lld.tictactoe;

public class Board {

  private static final int DEFAULT_BOARD_SIZE = 3;
  private final char[][] board;

  public Board() {
    this.board = new char[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
    for (int i = 0; i < this.getBoardLength(); ++i) {
      for (int j = 0; j < this.getBoardHeight(); ++j) {
        this.getBoard()[i][j] = '*';
      }
    }
  }

  private char[][] getBoard() {
    return this.board;
  }

  public int getBoardLength() {
    return this.getBoard()[0].length;
  }

  public int getBoardHeight() {
    return this.getBoard().length;
  }

  public char getPositionalValue(int x, int y) {
    return this.getBoard()[x - 1][y - 1];
  }

  public void setPositionalValue(int x, int y, char symbol) {
    this.getBoard()[x - 1][y - 1] = symbol;
  }

  public void printBoard() {
    for (int i = 1; i <= this.getBoardLength(); ++i) {
      for (int j = 1; j <= this.getBoardHeight(); ++j) {
        System.out.print(this.getPositionalValue(i, j) + " ");
      }
      System.out.println();
    }
  }
}
