package adventure.game.location.normal;

import adventure.game.player.Player;
import java.util.Scanner;

public class ToolStoreLocation implements NormalLocation {

  private final Scanner scanner;
  private final Player player;
  private boolean isMenuActive = false;

  public ToolStoreLocation(Player player) {
    scanner = new Scanner(System.in);
    this.player = player;
    onLocation();
  }

  @Override
  public boolean onLocation() {
    showMenu();
    char ch = scanner.next().charAt(0);
    if (ch == 'c') {
      return false;
    } else if (ch != 'h' && ch != 'r' && ch != 's' && ch != '1' && ch != '2' && ch != '3') {
      System.out.println("Please enter correct key to take an action...");
      return onLocation();
    }
    if (ch != 'c') {
      buy(ch);
    }
    return false;
  }

  @Override
  public void showMenu() {
    String st = "Do you want to buy a tool (enter 'c' to cancel) ?"
        + "Weapons: Handgun(h), Rifle(r), Sword(s)"
        + "Armors: Light(1), Mid(2), Weighty(3)";
    System.out.println(st);
    isMenuActive = true;
  }

  @Override
  public boolean isMenuActive() {
    return isMenuActive;
  }

  public void buy(char ch) {
    switch (ch) {
      case 'h' -> player.addHandgun();
      case 'r' -> player.addRifle();
      case 's' -> player.addSword();
      case '1' -> player.addLightArmor();
      case '2' -> player.addMidArmor();
      case '3' -> player.addHeavyArmor();
      default -> System.out.println("Please enter a correct input...");
    }
    isMenuActive = false;
  }
}
