package fakru.lld.uno;

public enum Card {
  RED_0(1),
  RED_1(2),
  RED_2(2),
  RED_3(2),
  RED_4(2),
  RED_5(2),
  RED_6(2),
  RED_7(2),
  RED_8(2),
  RED_9(2),
  RED_PLUS_2(2),
  RED_SKIP(2),
  RED_REVERSE(2),

  BLUE_0(1),
  BLUE_1(2),
  BLUE_2(2),
  BLUE_3(2),
  BLUE_4(2),
  BLUE_5(2),
  BLUE_6(2),
  BLUE_7(2),
  BLUE_8(2),
  BLUE_9(2),
  BLUE_PLUS_2(2),
  BLUE_SKIP(2),
  BLUE_REVERSE(2),

  YELLOW_0(2),
  YELLOW_1(2),
  YELLOW_2(2),
  YELLOW_3(2),
  YELLOW_4(2),
  YELLOW_5(2),
  YELLOW_6(2),
  YELLOW_7(2),
  YELLOW_8(2),
  YELLOW_9(2),
  YELLOW_PLUS_2(2),
  YELLOW_SKIP(2),
  YELLOW_REVERSE(2),

  GREEN_0(2),
  GREEN_1(2),
  GREEN_2(2),
  GREEN_3(2),
  GREEN_4(2),
  GREEN_5(2),
  GREEN_6(2),
  GREEN_7(2),
  GREEN_8(2),
  GREEN_9(2),
  GREEN_PLUS_2(2),
  GREEN_SKIP(2),
  GREEN_REVERSE(2),

  MULTI_PLUS_1(1),
  MULTI_PLUS_2(2),
  MULTI_PLUS_4(4);

  final int count;

  Card(int count) {
    this.count = count;
  }

  public int getCount() {
    return count;
  }

  public static Card fromString(String inputCard) {
    for (Card card : values()) {
      if (card.name().equalsIgnoreCase(inputCard)) {
        return card;
      }
    }
    throw new RuntimeException("Invalid card");
  }
}
