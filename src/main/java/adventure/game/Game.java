package adventure.game;

import adventure.game.character.Archer;
import adventure.game.character.Knight;
import adventure.game.character.Samurai;
import adventure.game.location.Location;
import adventure.game.location.battle.Cave;
import adventure.game.location.battle.Forest;
import adventure.game.location.battle.River;
import adventure.game.location.normal.SafeLocation;
import adventure.game.location.normal.ToolStoreLocation;
import adventure.game.player.Player;
import java.util.Scanner;

public class Game {

  private final Scanner scanner;
  private Location location;
  private Player player;

  public Game() {
    scanner = new Scanner(System.in);
    location = new SafeLocation();
  }


  public void createPlayer(char ch) {
    switch (ch) {
      case 's' -> player = new Player(new Samurai());
      case 'a' -> player = new Player(new Archer());
      case 'k' -> player = new Player(new Knight());
      default -> player = new Player();
    }
    resetHealthy();
  }

  public void startGame() {
    new Thread(() -> {
      while (player.getHealthy() > 0) {
        if (!location.isMenuActive()) {
          selectLocation();
          char ch = scanner.next().toLowerCase().charAt(0);
          refreshLocation(ch);
        }
      }
    }).start();
  }


  private void selectLocation() {
    String st = """
        Do you want to change your location?
         Safe area (1)
         Tool store (2)
         Cave (3)
         Forest (4)
         River (5)
         Stay same location (6)
         ------------------------""";
    System.out.println(st);
  }

  private void refreshLocation(char ch) {
    switch (ch) {
      case '1' -> location = new SafeLocation();
      case '2' -> location = new ToolStoreLocation(player);
      case '3' -> location = new Cave();
      case '4' -> location = new Forest();
      case '5' -> location = new River();
      default -> location.onLocation();
    }
  }

  private void resetHealthy() {
    switch (player.getName()) {
      case "Knight" -> player.setHealthy(Knight.HEALTHY);
      case "Samurai" -> player.setHealthy(Samurai.HEALTHY);
      case "Archer" -> player.setHealthy(Archer.HEALTHY);
      default -> player.setHealthy(0);
    }
  }
}
