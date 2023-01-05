package adventure.game.location.battle;

import adventure.game.obstacle.Vampire;
import adventure.game.player.Player;
import java.util.concurrent.ThreadLocalRandom;

public class Forest implements BattleLocation {

  private final Player player;
  private Vampire[] randomVampire;
  private boolean isMenuActive = false;

  public Forest(Player player) {
    this.player = player;
    onLocation();
  }

  @Override
  public boolean onLocation() {
    showMenu();
    char ch = scanner.next().charAt(0);
    if (ch == '1') {
      randomVampire = new Vampire[ThreadLocalRandom.current().nextInt(1, 3)];
      for (int i = 0; i < randomVampire.length; i++) {
        randomVampire[i] = new Vampire();
      }
      fight();
    } else if (ch == '2') {
      isMenuActive = false;
    } else {
      System.out.println("Please enter correct input...");
      onLocation();
    }
    return false;
  }

  private void fight() {
    showFightMenu();
    char ch = scanner.next().charAt(0);
    switch (ch) {
      case 'f' -> {
        int leftVampire = randomVampire.length;
        while (ch == 'f' && leftVampire > 0) {
          int damage = player.getDamage();
          int monsterHealth = randomVampire[leftVampire - 1].giveDamage(damage);
          System.out.println("Your damage: " + damage);
          boolean isVampireDead = fightWithVampire(monsterHealth);
          if (isVampireDead) {
            leftVampire--;
            System.out.println("How many vampires are alive: " + leftVampire);
          }
          if (leftVampire == 0 && player.getHealthy() > 0) {
            System.out.println(
                "Wow you killed all of the vampires in the forest. So you earned 'WOODEN'...");
            player.addWooden();
          }
          if (player.getHealthy() > 0 && leftVampire > 0) {
            System.out.println(
                "Do you want to change your location (c) or continue attacking(f) ?");
            ch = scanner.next().charAt(0);
          }
        }
        isMenuActive = false;
      }
      case 'c' -> {
        isMenuActive = false;
      }
      default -> {
        System.out.println("Please enter correct input...");
        fight();
      }
    }
  }

  private void showFightMenu() {
    String st = String.format("""
            +---------------------------------------------------------------------------------------+
            |                     Be careful!!!! Vampireeee... Ohh how many: %d                     |
            +---------------------------------------------------------------------------------------+
            | Do you want to fight or run away?                                                     |
            | Don't forget first shoot is yours, but you attack once, the vampire will attack you!" |
            | Fight (f)                                                                             |
            | Change the location (c)                                                               |
            +---------------------------------------------------------------------------------------+""",
        randomVampire.length);
    System.out.println(st);
  }

  private boolean fightWithVampire(int monsterHealth) {
    boolean isVampireDead = false;
    if (monsterHealth <= 0) {
      player.addMoney(Vampire.MONEY);
      String st = String.format("""  
          +-------------------------------+
          | Wooow you killed one vampire. |
          +-------------------------------+
          | You earned %d                 |
          | Your total money: %d          |
          +-------------------------------+""", Vampire.MONEY, player.getMoney());
      System.out.println(st);
      isVampireDead = true;
    } else {
      player.giveDamage(Vampire.DAMAGE);
      System.out.println("One attack from the vampire : " + Vampire.DAMAGE);
    }
    System.out.println("Your left health : " + player.getHealthy());
    return isVampireDead;
  }

  @Override
  public void showMenu() {
    showMenu("FOREST");
    isMenuActive = true;
  }

  @Override
  public boolean isMenuActive() {
    return isMenuActive;
  }

  @Override
  public String getName() {
    return "FOREST";
  }
}
