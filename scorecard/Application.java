package fakru.lld.scorecard;

import java.util.List;
import java.util.Scanner;

public class Application {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("Number of players for each team : ");
    int playersCount = scanner.nextInt();
    System.out.print("Number of overs : ");
    int overs = scanner.nextInt();
    init(playersCount, overs);
  }

  private static void init(int playersCount, int overs) {
    Team t1 = new Team("team1", playersCount, overs);
    Team t2 = new Team("team1", playersCount, overs);
    batting(t1);
    printStats(t1.getPlayerList());
    batting(t2);
    printStats(t1.getPlayerList());
  }

  private static void printStats(List<Player> playerList) {
    System.out.println("Name | runs | balls | fours | sixes | ");
    for (Player p : playerList) {
      System.out.println(
          p.getName() + " | " + p.getRuns() + " | " + p.getBalls() + " | " + p.getFours() + " | "
              + p.getSixes() + " | " + (p.isOut() ? "" : "not-out"));
    }
  }

  private static void batting(Team t) {
    while (t.getCurrBall() < t.getOvers() * 6) {
      System.out.print("current ball status : ");
      String currBallStatus = scanner.next();
      if ("W".equals(currBallStatus)) {
        t.setTotal(t.getTotal() + 1);
      } else if ("N".equals(currBallStatus)) {
        t.setTotal(t.getTotal() + 1);
      } else if ("O".equals(currBallStatus)) {
        t.getStriker().setOut();
        t.getStriker().setBalls(t.getStriker().getBalls() + 1);
        t.setStriker(t.getNextPlayer());
        t.setCurrBall(t.getCurrBall() + 1);
      } else {
        int runs = Integer.parseInt(currBallStatus);
        t.getStriker().setRuns(t.getStriker().getRuns() + runs);
        if (runs == 4) {
          t.getStriker().setFours(t.getStriker().getFours() + 1);
        } else if (runs == 6) {
          t.getStriker().setSixes(t.getStriker().getSixes() + 1);
        }
        t.getStriker().setBalls(t.getStriker().getBalls() + 1);
        t.setCurrBall(t.getCurrBall() + 1);

        if (runs % 2 == 1) {
          rotateStrike(t);
        }
      }

      if (t.getCurrBall() % 6 == 0) {
        rotateStrike(t);
      }
    }
  }

  private static void rotateStrike(Team t) {
    Player temp = t.getStriker();
    t.setStriker(t.getNonStriker());
    t.setNonStriker(temp);
  }
}