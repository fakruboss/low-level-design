package fakru.lld.tictactoe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TicTacToeDemo {

  private final Random rand = new Random();
  List<List<Move>> movesHistory = new LinkedList<>();

  public static void main(String[] args) {
    TicTacToeDemo ticTacToe = new TicTacToeDemo();
    Player p1 = new Player("Ajith", 'X');
    Player p2 = new Player("Jeeva", 'O');
    for (int i = 1; i <= 10000; ++i) {
      p1.incrementTotalGamesCount();
      p2.incrementTotalGamesCount();
      ticTacToe.startGame(new Game(), p1, p2);
    }
    p1.printPlayerSummary();
    p2.printPlayerSummary();
  }

  private void startGame(Game game, Player p1, Player p2) {
    List<Move> moves = new ArrayList<>();
    int moveCount = 1;
    boolean isGameOver = false;
    while (!isGameOver && moveCount <= 9) {
      Player p = moveCount % 2 == 1 ? p1 : p2;
      System.out.println(moveCount + " : Enter " + p.getName() + "'s position");

      try {
        Move move = Move.generateRandomMove(game);
        boolean isMoveMade = game.makeMove(p, move);
        if (isMoveMade) {
          moves.add(move);
          ++moveCount;
          game.getBoard().printBoard();
        }
        moveCount = undoMove(game, moveCount, moves);

        isGameOver = game.isGameOver(move);
        if (isGameOver) {
          p.incrementWinningCount();
          System.out.println("-----" + p.getName().toUpperCase() + " WON THE GAME -----");
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    if (!isGameOver) {
      p1.incrementDrawCount();
      p2.incrementDrawCount();
      System.out.println("-----GAME DRAWN-----");
    }
    movesHistory.add(moves);
  }

  private int undoMove(Game game, int moveCount, List<Move> moves) {
    boolean isUndo = (rand.nextInt(Integer.MAX_VALUE) % 5) == 4;
    if (isUndo && moveCount != 1) {
      System.out.println("-----REVERTING PREVIOUS MOVE-----");
      boolean isMoveReverted = game.undoPreviousMove(moves);
      if (isMoveReverted) {
        --moveCount;
      }
    }
    return moveCount;
  }
}