package fakru.lld.uno;

import java.util.EnumMap;
import java.util.Map;

public class Deck {

  private EnumMap<Card, Integer> deck;

  Deck() {
    this.deck = new EnumMap<>(Card.class);
  }

  public Map<Card, Integer> getDeck() {
    return deck;
  }

  @Override
  public String toString() {
    return "Deck{" +
        "deck=" + deck +
        '}';
  }
}