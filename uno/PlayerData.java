package fakru.lld.uno;

import java.util.HashMap;
import java.util.Map;

public class PlayerData {

  private PlayerData() {
  }

  private static Map<Player, Deck> playerDeckMap;
  private static Map<Integer, Player> playerIndexMap;

  public static Map<Player, Deck> getPlayerDeckData() {
    if (playerDeckMap == null || playerDeckMap.isEmpty()) {
      playerDeckMap = new HashMap<>();
    }
    return playerDeckMap;
  }

  public static Map<Integer, Player> getPlayerIndexMap() {
    if (playerIndexMap == null || playerIndexMap.isEmpty()) {
      playerIndexMap = new HashMap<>();
    }
    return playerIndexMap;
  }
}