package fakru.lld.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicTacToeDemo {

  public static void main(String[] args) {
    Random rand = new Random();
    Player p1 = new Player("Ajith", 'X');
    Player p2 = new Player("Jeeva", 'O');
    for (int i = 1; i <= 100000; ++i) {
      int moveCount = 1;
      boolean isGameOver = false;
      p1.incrementTotalGamesCount();
      p2.incrementTotalGamesCount();
      Game game = new Game();
      List<Move> listOfMoves = new ArrayList<>();
      while (!isGameOver && moveCount <= 9) {
        Player p = moveCount % 2 == 1 ? p1 : p2;
        System.out.println(moveCount + " : Enter " + p.getName() + "'s position");
        int x = (rand.nextInt(Integer.MAX_VALUE) % 3) + 1;
        int y = (rand.nextInt(Integer.MAX_VALUE) % 3) + 1;
        System.out.println(x + " " + y);
        try {
          Move move = new Move(x, y);
          boolean isMoveMade = game.makeMove(p, move);
          if (isMoveMade) {
            listOfMoves.add(move);
            game.getBoard().printBoard();
            ++moveCount;
          }
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
    }
    p1.printPlayerSummary();
    p2.printPlayerSummary();
  }
}