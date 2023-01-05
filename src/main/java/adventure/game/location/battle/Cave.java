package adventure.game.location.battle;

import adventure.game.obstacle.Zombie;
import adventure.game.player.Player;
import java.util.concurrent.ThreadLocalRandom;

public class Cave implements BattleLocation {

  private final Player player;
  private boolean isMenuActive = false;
  private Zombie[] randomZombie;

  public Cave(Player player) {
    this.player = player;
    onLocation();
  }

  @Override
  public boolean onLocation() {
    showMenu();
    char ch = scanner.next().charAt(0);
    if (ch == '1') {
      randomZombie = new Zombie[ThreadLocalRandom.current().nextInt(1, 3)];
      for (int i = 0; i < randomZombie.length; i++) {
        randomZombie[i] = new Zombie();
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
        int leftZombie = randomZombie.length;
        while (ch == 'f' && leftZombie > 0) {
          int damage = player.getDamage();
          int monsterHealth = randomZombie[leftZombie - 1].giveDamage(damage);
          boolean isZombieDead = fightWithZombie(monsterHealth);
          if (isZombieDead) {
            leftZombie--;
            System.out.println("How many zombies are alive: " + leftZombie);
          }
          if (leftZombie == 0 && player.getHealthy() > 0) {
            System.out.println(
                "Wow you killed all of the zombies in the cave. So you earned 'FOOD'...");
            player.addFood();
          }
          if (player.getHealthy() > 0) {
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
            +-------------------------------------------------------------------------------------+
            |                     Be careful!!!! Zombieee... Ohh how many: %d                     |
            +-------------------------------------------------------------------------------------+
            | Do you want to fight or run away?                                                   |
            | Don't forget first shoot is yours, but you attack once, the zombie will attack you! |
            | Fight (f)                                                                           |
            | Change the location (c)                                                             |
            +-------------------------------------------------------------------------------------+""",
        randomZombie.length);
    System.out.println(st);
  }

  private boolean fightWithZombie(int monsterHealth) {
    boolean isZombieDead = false;
    if (monsterHealth <= 0) {
      player.addMoney(Zombie.MONEY);
      String st = String.format("""
          +------------------------------+
          | Wooow you killed one zombie. |
          +------------------------------+
          | You earned %d                |
          | Your total money: %d         |
          +------------------------------+""", Zombie.MONEY, player.getMoney());
      System.out.println(st);
      isZombieDead = true;
    } else {
      player.giveDamage(Zombie.DAMAGE);
      System.out.println("One attack from the zombie : " + Zombie.DAMAGE);
    }
    System.out.println("Your left health : " + player.getHealthy());
    return isZombieDead;
  }

  @Override
  public void showMenu() {
    showMenu("CAVE");
    isMenuActive = true;
  }

  @Override
  public boolean isMenuActive() {
    return isMenuActive;
  }
}
