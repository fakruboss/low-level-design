package fakru.lld.scorecard;

public class Player {

  private final String name;
  private int runs;
  private int balls;
  private int fours;
  private int sixes;
  private boolean isOut = false;

  public void setOut() {
    isOut = true;
  }

  public String getName() {
    return name;
  }

  public int getRuns() {
    return runs;
  }

  public int getBalls() {
    return balls;
  }

  public int getFours() {
    return fours;
  }

  public int getSixes() {
    return sixes;
  }

  public void setRuns(int runs) {
    this.runs = runs;
  }

  public void setBalls(int balls) {
    this.balls = balls;
  }

  public void setFours(int fours) {
    this.fours = fours;
  }

  public void setSixes(int sixes) {
    this.sixes = sixes;
  }

  public Player(String name) {
    this.name = name;
  }

  public boolean isOut() {
    return isOut;
  }
}