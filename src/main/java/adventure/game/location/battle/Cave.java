package adventure.game.location.battle;

import adventure.game.monster.Zombie;
import adventure.game.player.Player;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author aysedemireldeniz
 */
public class Cave extends BattleLocation {


  public Cave(Player player) {
    this.player = player;
    onLocation();
  }

  @Override
  public void createMonsters() {
    randomMonster = new Zombie[ThreadLocalRandom.current().nextInt(1, 3)];
    for (int i = 0; i < randomMonster.length; i++) {
      randomMonster[i] = new Zombie();
    }
  }

  @Override
  public String getMonsterName() {
    return "Zombie";
  }

  @Override
  public void killMonster() {
    player.addMoney(Zombie.MONEY);
    String st = String.format("""
        +------------------------------+
        | Wooow you killed one zombie. |
        +------------------------------+
        | You earned %d                |
        | Your total money: %d         |
        +------------------------------+""", Zombie.MONEY, player.getMoney());
    System.out.println(st);
  }

  @Override
  void fightWithMonster(int monsterHealth) {
    if (monsterHealth <= 0) {
      killMonster();
    } else {
      player.attackToPlayer(Zombie.DAMAGE);
      System.out.println("One attack from the zombie : " + Zombie.DAMAGE);
    }
    System.out.println("Your left health : " + player.getHealthy());
  }

  @Override
  public void showMenu() {
    showMenu("CAVE");
    isMenuActive = true;
  }

  @Override
  public String getName() {
    return "CAVE";
  }

  @Override
  void earnGift(int leftMonster) {
    if (leftMonster == 0 && player.getHealthy() > 0) {
      System.out.println(
          "Wow you killed all of the zombies in the river. So you earned 'FOOD'...");
      player.addFood();
    }
  }
}
