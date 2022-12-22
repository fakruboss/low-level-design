package fakru.lld;

import fakru.lld.tictactoe.Position;
import java.util.Random;
import java.util.Scanner;

/**
 * https://workat.tech/machine-coding/practice/design-2048-game-osycd22zpn1y
 */
public class TwoZeroFourEight {

  static int[][] board;
  Random rand = new Random();
  static final int BOARD_SIZE = 4;

  private boolean isGameOver() {
    for (int[] row : board) {
      for (int j = 0; j < board[0].length; ++j) {
        if (row[j] == 0) {
          return false;
        }
      }
    }
    return true;
  }

  private Position generateRandomLocation() {
    while (true) {
      int x = rand.nextInt(4);
      int y = rand.nextInt(4);
      if (board[x][y] == 0) {
        return new Position(x, y);
      }
      return null;
    }
  }

  private int getRandomValue() {
    int num = rand.nextInt(6);
    return num == 4 ? 4 : 2;
  }

  private void fillBoard(Position p, int value) {
    board[p.getX()][p.getY()] = value;
  }

  private void init() {
    for (int i = 0; i < 2; ++i) {
      fillBoard(generateRandomLocation(), getRandomValue());
    }
  }

  private void printBoard() {
    for (int[] row : board) {
      for (int j = 0; j < board[0].length; ++j) {
        System.out.print(row[j] + " ");
      }
      System.out.println();
    }
  }

  private void moveUp() {
    for (int i = 0; i < board.length - 1; ++i) {
      for (int j = 0; j < board.length; ++j) {
        if (board[i][j] != 0 && board[i][j] == board[i + 1][j]) {
          board[i][j] = 2 * board[i][j];
          board[i + 1][j] = 0;
        } else if (board[i][j] == 0) {
          board[i][j] = board[i + 1][j];
          board[i + 1][j] = 0;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    board = new int[BOARD_SIZE][BOARD_SIZE];
    TwoZeroFourEight twoZeroFourEight = new TwoZeroFourEight();
    twoZeroFourEight.init();
    while (!twoZeroFourEight.isGameOver()) {
      twoZeroFourEight.printBoard();
      System.out.print("Enter next move : ");
      int nextMove = scan.nextInt();
      if (nextMove == 0) {
        twoZeroFourEight.moveUp();
      }
    }
  }
}