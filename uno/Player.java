package fakru.lld.uno;

public class Player {

  private final String name;

  public Player(final String name) {
    this.name = name;
    addPlayerToMap(this);
  }

  private void addPlayerToMap(Player player) {
    PlayerData.getPlayerDeckData().put(player, new Deck());
  }

  @Override
  public String toString() {
    return "Player{" +
        "name='" + name + '\'' +
        '}';
  }
}