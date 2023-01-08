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

/**
 * @author aysedemireldeniz
 */
public class Game {

  private final Scanner scanner;
  private Location location;
  private Player player;

  public Game() {
    scanner = new Scanner(System.in);
  }

  public void selectCharacter() {
    System.out.print(getSelectCharMenu());
    System.out.println("Choose character:");
    char ch = scanner.next().toLowerCase().charAt(0);
    createPlayer(ch);
  }

  private String getSelectCharMenu() {
    return Samurai.getCharMenu()
        + Archer.getCharMenu()
        + Knight.getCharMenu();
  }

  public void createPlayer(char ch) {
    switch (ch) {
      case 's' -> player = new Player(new Samurai());
      case 'a' -> player = new Player(new Archer());
      case 'k' -> player = new Player(new Knight());
      default -> player = new Player();
    }
    location = new SafeLocation(player);
  }

  public void startGame() {
    new Thread(() -> {
      while (player.getHealthy() > 0) {
        if (!location.isMenuActive()) {
          selectLocation();
          char ch = scanner.next().toLowerCase().charAt(0);
          refreshLocation(ch);
          if (player.isWin()) {
            System.out.println("You WIN !!!!! ");
            break;
          }
        }
      }
      if (player.getHealthy() == 0) {
        System.out.println("Game over...");
      }
      restart();
    }).start();
  }

  private void restart() {
    System.out.println("Do you want to start again ? Yes(y)");
    char ch = scanner.next().toLowerCase().charAt(0);
    if (ch == 'y') {
      selectCharacter();
      startGame();
    }
  }

  private void selectLocation() {
    String st = String.format("""
            +--------------------------------------+
            You are in %s
            Do you want to change your location?
            +--------------------------------------+
            | Safe area (1)                        |
            | Tool store (2)                       |
            """,
        location.getName());
    if (!player.isCaveFinish()) {
      st += "| Cave(3)                              |\n";
    }
    if (!player.isForestFinish()) {
      st += "| Forest(4)                            |\n";
    }
    if (!player.isRiverFinish()) {
      st += "| River(5)                             |\n";
    }
    st += """
        | Stay same location (6)               |
        | Print player info (7)                |
        +--------------------------------------+""";
    System.out.println(st);
  }

  private void refreshLocation(char ch) {
    switch (ch) {
      case '1' -> location = new SafeLocation(player);
      case '2' -> location = new ToolStoreLocation(player);
      case '3' -> {
        if (player.isCaveFinish()) {
          wrongInput();
        } else {
          location = new Cave(player);
        }
      }
      case '4' -> {
        if (player.isForestFinish()) {
          wrongInput();
        } else {
          location = new Forest(player);
        }
      }
      case '5' -> {
        if (player.isRiverFinish()) {
          wrongInput();
        } else {
          location = new River(player);
        }
      }
      case '7' -> player.printPlayer();
      default -> wrongInput();
    }
  }

  private void wrongInput() {
    System.out.println("Wrong input");
    location.onLocation();
  }
}
