package adventure.game;

import adventure.game.character.Archer;
import adventure.game.character.Knight;
import adventure.game.character.Samurai;
import adventure.game.location.Location;
import adventure.game.location.normal.SafeLocation;
import adventure.game.player.Player;
import java.util.Scanner;

public class Game {

  private final Scanner scanner;
  private final Location location;
  private Player player;

  public Game() {
    scanner = new Scanner(System.in);
    startGame();
    location = new SafeLocation();

  }

  public void startGame() {
    StringBuilder builder = new StringBuilder();
    builder.append("-------------------\n");
    builder.append("Samurai (s)\n");
    builder.append("Archer (a)\n");
    builder.append("Knight (k)\n");
    builder.append("Choose character:");
    System.out.println(builder);
    char ch = scanner.next().toLowerCase().charAt(0);
    createPlayer(ch);
    System.out.println("-------------------\n");
  }

  private void createPlayer(char ch) {
    switch (ch) {
      case 's' -> player = new Player(new Samurai());
      case 'a' -> player = new Player(new Archer());
      case 'k' -> player = new Player(new Knight());
      default -> player = new Player();
    }
  }
}
