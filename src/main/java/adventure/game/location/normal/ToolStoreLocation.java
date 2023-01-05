package adventure.game.location.normal;

import adventure.game.armor.LightArmor;
import adventure.game.armor.MidArmor;
import adventure.game.armor.WeightyArmor;
import adventure.game.player.Player;
import adventure.game.weapon.Handgun;
import adventure.game.weapon.Rifle;
import adventure.game.weapon.Sword;

public class ToolStoreLocation implements NormalLocation {

  private final Player player;
  private boolean isMenuActive = false;

  public ToolStoreLocation(Player player) {
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
    } else {
      buy(ch);
    }
    return false;
  }

  @Override
  public void showMenu() {
    String st = String.format("""
            +------------------------------------------------------------------------------------------------------------------------+
            | Do you want to buy a tool (enter 'c' to cancel) ?                                                                      |
            +----------+------------------------------------+----------------------------------+-------------------------------------+
            | Weapons: | HANDGUN(h)--> damage: %d money: %d | RIFLE(r)--> damage: %d money: %d | SWORD(s)--> damage: %d money: %d    |
            +----------+------------------------------------+----------------------------------+-------------------------------------+
            | Armors:  | LIGHT(1)--> damage: %d money: %d   | MID(2)--> damage: %d money: %d  | WEIGHTY(3)--> damage: %d money: %d   |
            +----------+------------------------------------+----------------------------------+-------------------------------------+""",
        Handgun.DAMAGE, Handgun.MONEY, Rifle.DAMAGE, Rifle.MONEY, Sword.DAMAGE, Sword.MONEY,
        LightArmor.DAMAGE, LightArmor.MONEY, MidArmor.DAMAGE, MidArmor.MONEY, WeightyArmor.DAMAGE,
        WeightyArmor.MONEY);
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
