package fakru.lld.uno;

import java.security.SecureRandom;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

  private static final Scanner input = new Scanner(System.in);
  private static final Random random = new SecureRandom();
  private static int gamePlayIndex = 0;

  private void createPlayers(int count) {
    for (int i = 0; i < count; ++i) {
      System.out.println("Enter player " + (i + 1) + " name");
      String name = input.next();
      Player player = new Player(name);
      Deck playerDeck = generateDeckForPlayer();
      PlayerData.getPlayerIndexMap().put(i, player);
      PlayerData.getPlayerDeckData().put(player, playerDeck);
    }
  }

  private Deck generateDeckForPlayer() {
    int cards = 7;
    Deck playerDeck = new Deck();
    while (cards > 0) {
      Map<Card, Integer> masterDeck = MasterDeck.getMasterDeck();
      int randomIndex = random.nextInt(MasterDeck.getRandomIndexMasterDeck().size());
      Card randomCard = MasterDeck.getRandomIndexMasterDeck().get(randomIndex);
      if (masterDeck.get(randomCard) != 0) {
        masterDeck.put(randomCard, masterDeck.get(randomCard) - 1);
        Map<Card, Integer> currentPlayerDeck = playerDeck.getDeck();
        currentPlayerDeck.put(randomCard, currentPlayerDeck.getOrDefault(randomCard, 0) + 1);
        --cards;
      }
    }
    return playerDeck;
  }

  private void gameStart(Card baseCard) {
    // TODO : first cut, assuming player 1 starts always
    System.out.println("Press 0 for drop and 1 for take");
    int choice = input.nextInt();
    if (choice == 0) {
      Card dropCard = Card.fromString(input.next());
      Player player = PlayerData.getPlayerIndexMap().get(gamePlayIndex);
      Deck deck = PlayerData.getPlayerDeckData().get(player);
      if (!deck.getDeck().containsKey(dropCard)) {
        throw new RuntimeException("selected card not present in player's deck");
      }
      // TODO : to check against base card
    } else if (choice == 1) {

    } else {
      throw new RuntimeException("Impossible choice");
    }
  }

  private boolean baseCardVsDropCard(Card baseCard, Card dropCard) {
    String baseCardColor = baseCard.name().split("-_")[0];
    String dropCardColor = dropCard.name().split("-_")[0];

    int baseCardNumber = Integer.parseInt(baseCard.name().split("_")[1]);
    int dropCardNumber = Integer.parseInt(dropCard.name().split("_")[1]);
    if (!checkAgainstColor(baseCardColor, dropCardColor)
        && !checkAgainstNumber(baseCardNumber, dropCardNumber)) {
      throw new RuntimeException("invalid drop card against the base card");
    }
    return true;
  }

  private boolean checkAgainstColor(String baseCardColor, String dropCardColor) {
    return baseCardColor.equalsIgnoreCase(dropCardColor);
  }

  private boolean checkAgainstNumber(int baseCardNumber, int dropCardNumber) {
    return baseCardNumber == dropCardNumber;
  }

  public static void main(String[] args) {
    Main main = new Main();
    System.out.println("Enter the player count");
    int playerCount = input.nextInt();
    main.createPlayers(playerCount);
    System.out.println(PlayerData.getPlayerDeckData());
    int randomIndex = random.nextInt(MasterDeck.getRandomIndexMasterDeck().size());
    Card randomCard = MasterDeck.getRandomIndexMasterDeck().get(randomIndex);
    main.gameStart(randomCard);
  }
}