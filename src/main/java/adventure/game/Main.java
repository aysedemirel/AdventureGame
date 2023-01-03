package adventure.game;

import adventure.game.character.Archer;
import adventure.game.character.Knight;
import adventure.game.character.Samurai;
import java.util.Scanner;

public class Main {

  private final Scanner scanner;
  private final Game game;

  public Main() {
    scanner = new Scanner(System.in);
    game = new Game();
    selectCharacter();
    game.startGame();
  }

  public static void main(String[] args) {
    new Main();
  }

  public void selectCharacter() {
    System.out.println("-------------------");
    System.out.print(getSelectCharMenu());
    System.out.println("Choose character:");
    char ch = scanner.next().toLowerCase().charAt(0);
    game.createPlayer(ch);
    System.out.println("-------------------");
  }

  private String getSelectCharMenu() {
    StringBuilder builder = new StringBuilder();
    builder.append(Samurai.getCharMenu());
    builder.append(Archer.getCharMenu());
    builder.append(Knight.getCharMenu());
    return builder.toString();
  }
}
