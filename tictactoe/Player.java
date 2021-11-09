package fakru.lld.tictactoe;

public class Player {

  private final String name;
  private final char symbol;
  private int totalGamesPlayed = 0;
  private int winCount = 0;
  private int drawCount = 0;

  public Player(String name, char symbol) {
    this.name = name;
    this.symbol = symbol;
  }

  public String getName() {
    return this.name;
  }

  public char getSymbol() {
    return symbol;
  }

  public void incrementWinningCount() {
    ++this.winCount;
  }

  public void incrementTotalGamesCount() {
    ++this.totalGamesPlayed;
  }

  public void incrementDrawCount() {
    ++this.drawCount;
  }

  public int getTotalGamesPlayed() {
    return totalGamesPlayed;
  }

  public int getWinCount() {
    return winCount;
  }

  public int getDrawCount() {
    return drawCount;
  }

  public void printPlayerSummary() {
    System.out.println("----------");
    System.out.println("-----SUMMARY-----");
    System.out.println(this.getName().toUpperCase());
    System.out.println("Total games played : " + this.getTotalGamesPlayed());
    System.out.println("Win count : " + this.getWinCount());
    System.out.println("Draw count : " + this.getDrawCount());
    System.out.println("----------");
  }
}