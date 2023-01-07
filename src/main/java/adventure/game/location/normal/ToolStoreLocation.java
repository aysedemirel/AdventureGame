package adventure.game.location.normal;

import adventure.game.location.Location;
import adventure.game.player.Player;
import adventure.game.tool.Armor;
import adventure.game.tool.Weapon;

public class ToolStoreLocation implements Location {

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
      isMenuActive = false;
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
            Your money: %d
            Do you want to buy a tool (enter 'c' to cancel) ?
            +----------+------------------------------------+----------------------------------+-------------------------------------+
            | Weapons: | HANDGUN(h)--> damage: %d money: %d | RIFLE(r)--> damage: %d money: %d | SWORD(s)--> damage: %d money: %d    |
            +----------+------------------------------------+----------------------------------+-------------------------------------+
            | Armors:  | LIGHT(1)--> damage: %d money: %d   | MID(2)--> damage: %d money: %d  | HEAVY(3)--> damage: %d money: %d   |
            +----------+------------------------------------+----------------------------------+-------------------------------------+""",
        player.getMoney(),
        Weapon.HANDGUN.getDamage(), Weapon.HANDGUN.getMoney(), Weapon.RIFLE.getDamage(),
        Weapon.RIFLE.getMoney(),
        Weapon.SWORD.getDamage(),
        Weapon.SWORD.getMoney(),
        Armor.LIGHT.getDamage(), Armor.LIGHT.getMoney(), Armor.MID.getDamage(),
        Armor.MID.getMoney(),
        Armor.HEAVY.getDamage(),
        Armor.HEAVY.getMoney());
    System.out.println(st);
    isMenuActive = true;
  }

  @Override
  public boolean isMenuActive() {
    return isMenuActive;
  }

  public void buy(char ch) {
    switch (ch) {
      case 'h' -> {
        if (player.isMoneyEnough(Weapon.HANDGUN.getMoney())) {
          player.addHandgun();
        }
      }
      case 'r' -> {
        if (player.isMoneyEnough(Weapon.RIFLE.getMoney())) {
          player.addRifle();
        }
      }
      case 's' -> {
        if (player.isMoneyEnough(Weapon.SWORD.getMoney())) {
          player.addSword();
        }
      }
      case '1' -> {
        if (player.isMoneyEnough(Armor.LIGHT.getMoney())) {
          player.addLightArmor();
        }
      }
      case '2' -> {
        if (player.isMoneyEnough(Armor.MID.getMoney())) {
          player.addMidArmor();
        }
      }
      case '3' -> {
        if (player.isMoneyEnough(Armor.HEAVY.getMoney())) {
          player.addHeavyArmor();
        }
      }
      default -> System.out.println("Please enter a correct input...");
    }
    isMenuActive = false;
  }

  @Override
  public String getName() {
    return "TOOL STORE";
  }
}
