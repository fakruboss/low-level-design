package fakru.lld.uno;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class MasterDeck {

  private MasterDeck() {
  }

  private static final EnumMap<Card, Integer> masterDeck = new EnumMap<>(Card.class);
  private static final Map<Integer, Card> randomIndexMasterDeck = new HashMap<>();

  static {
    int index = 0;
    for (Card card : Card.values()) {
      masterDeck.put(card, card.getCount());
      for (int i = 0; i < card.getCount(); ++i) {
        randomIndexMasterDeck.put(index++, card);
      }
    }
  }

  public static Map<Card, Integer> getMasterDeck() {
    return masterDeck;
  }

  public static Map<Integer, Card> getRandomIndexMasterDeck() {
    return randomIndexMasterDeck;
  }
}