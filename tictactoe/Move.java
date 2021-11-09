package fakru.lld.tictactoe;

import java.util.List;
import java.util.Random;

public class Move {

  private static final Random rand = new Random();
  private final int x;
  private final int y;

  public Move(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public static Move generateRandomMove(Game game) {
    List<Move> moves = game.getAvailableMoves();
    int index = rand.nextInt(moves.size());
    Move move = moves.get(index);
    game.removeUtilisedMove(move);
    System.out.println("Generated move => Row : " + move.getX() + " Column : " + move.getY());
    return move;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}