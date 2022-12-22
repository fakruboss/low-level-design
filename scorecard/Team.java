package fakru.lld.scorecard;

import java.util.ArrayList;
import java.util.List;

public class Team {

  private String name;
  private int playersCount;
  private List<Player> playerList;

  private int overs;
  private int currBall;
  private int total;

  private Player striker;
  private Player nonStriker;
  private Player currLastPlayer;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPlayersCount() {
    return playersCount;
  }

  public void setPlayersCount(int playersCount) {
    this.playersCount = playersCount;
  }

  public List<Player> getPlayerList() {
    return playerList;
  }

  public void setPlayerList(List<Player> playerList) {
    this.playerList = playerList;
  }

  public int getOvers() {
    return overs;
  }

  public void setOvers(int overs) {
    this.overs = overs;
  }

  public int getCurrBall() {
    return currBall;
  }

  public void setCurrBall(int currBall) {
    this.currBall = currBall;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public Player getStriker() {
    return striker;
  }

  public void setStriker(Player striker) {
    this.striker = striker;
  }

  public Player getNonStriker() {
    return nonStriker;
  }

  public void setNonStriker(Player nonStriker) {
    this.nonStriker = nonStriker;
  }

  public Player getCurrLastPlayer() {
    return currLastPlayer;
  }

  public void setCurrLastPlayer(Player currLastPlayer) {
    this.currLastPlayer = currLastPlayer;
  }

  public Team(String name, int playersCount, int overs) {
    this.name = name;
    this.playersCount = playersCount;
    this.overs = overs;
    this.playerList = new ArrayList<>();

    this.striker = new Player("P" + 1);
    this.nonStriker = new Player("P" + 2);
    playerList.add(striker);
    playerList.add(nonStriker);
    this.currLastPlayer = nonStriker;
  }

  public Player getNextPlayer() {
    String currLastPlayerName = this.currLastPlayer.getName();
    int nextPlayerIndex = currLastPlayerName.charAt(1) + 1 - '0';
    Player p = new Player("P" + nextPlayerIndex);
    playerList.add(p);
    setCurrLastPlayer(p);
    return p;
  }
}