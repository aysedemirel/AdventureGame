package adventure.game.location.battle;

import adventure.game.obstacle.Bear;
import adventure.game.player.Player;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class River implements BattleLocation {

  private final Player player;
  private final Scanner scanner;
  private boolean isMenuActive = false;

  private Bear[] randomBear;

  public River(Player player) {
    scanner = new Scanner(System.in);
    this.player = player;
    onLocation();
  }

  @Override
  public boolean onLocation() {
    showMenu();
    char ch = scanner.next().charAt(0);
    if (ch == '1') {
      randomBear = new Bear[ThreadLocalRandom.current().nextInt(1, 3)];
      for (int i = 0; i < randomBear.length; i++) {
        randomBear[i] = new Bear();
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
    System.out.println("Be careful!!!! Giant bear... Ohh how many:" + randomBear.length);
    System.out.println(
        "Do you want to fight or run away? "
            + "Don't forget first shoot is yours, but you hit once bear will attack you!");
    System.out.println("Fight (f)");
    System.out.println("Change the location (c)");
    char ch = scanner.next().charAt(0);
    switch (ch) {
      case 'f' -> {
        int leftBear = randomBear.length;
        while (ch == 'f' && leftBear > 0) {
          int damage = player.getDamage();
          int monsterHealth = randomBear[leftBear - 1].giveDamage(damage);
          if (monsterHealth <= 0) {
            leftBear--;
            player.addMoney(Bear.MONEY);
            System.out.println(
                "Wooow you killed one bear. You earn " + Bear.MONEY + " your total money: "
                    + player.getMoney());
            System.out.println("How many bears are alive: " + leftBear);
          } else {
            player.giveDamage(Bear.DAMAGE);
            System.out.println("One attack from the bear : " + Bear.DAMAGE);
          }
          System.out.println("Your left health : " + player.getHealthy());
          if (player.getHealthy() > 0) {
            System.out.println(
                "Do you want to change your location (c) or continue attacking(f) ?");
            ch = scanner.next().charAt(0);
          }
        }
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

  @Override
  public void showMenu() {
    StringBuilder st = new StringBuilder();
    st.append("You are in RIVER...");
    st.append("Look around (1)");
    st.append("Return main menu (2)");
    System.out.println(st);
    isMenuActive = true;
  }

  @Override
  public boolean isMenuActive() {
    return isMenuActive;
  }

}
