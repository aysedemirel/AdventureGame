package adventure.game.location.battle;

import adventure.game.monster.Bear;
import adventure.game.player.Player;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author aysedemireldeniz
 */
public class River extends BattleLocation {

  public River(Player player) {
    this.player = player;
    onLocation();
  }

  @Override
  public void createMonsters() {
    randomMonster = new Bear[ThreadLocalRandom.current().nextInt(1, 3)];
    for (int i = 0; i < randomMonster.length; i++) {
      randomMonster[i] = new Bear();
    }
  }

  @Override
  public String getMonsterName() {
    return "Bear";
  }

  @Override
  void killMonster() {
    player.addMoney(Bear.MONEY);
    String st = String.format("""
        +----------------------------+
        | Wooow you killed one bear. |
        +----------------------------+
        | You earned %d              |
        | Your total money: %d       |
        +----------------------------+""", Bear.MONEY, player.getMoney());
    System.out.println(st);
  }

  @Override
  void fightWithMonster(int monsterHealth) {
    if (monsterHealth <= 0) {
      killMonster();
    } else {
      player.attackToPlayer(Bear.DAMAGE);
      System.out.println("One attack from the bear : " + Bear.DAMAGE);
    }
    System.out.println("Your left health : " + player.getHealthy());
  }

  @Override
  public void showMenu() {
    showMenu("RIVER");
    isMenuActive = true;
  }

  @Override
  public String getName() {
    return "RIVER";
  }

  @Override
  void earnGift(int leftMonster) {
    if (leftMonster == 0 && player.getHealthy() > 0) {
      System.out.println(
          "Wow you killed all of the bears in the river. So you earned 'WATER'...");
      player.addWater();
    }
  }
}
