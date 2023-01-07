package adventure.game.location.battle;

import adventure.game.monster.Vampire;
import adventure.game.player.Player;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author aysedemireldeniz
 */
public class Forest extends BattleLocation {

  public Forest(Player player) {
    this.player = player;
    onLocation();
  }

  @Override
  public void createMonsters() {
    randomMonster = new Vampire[ThreadLocalRandom.current().nextInt(1, 3)];
    for (int i = 0; i < randomMonster.length; i++) {
      randomMonster[i] = new Vampire();
    }
  }

  @Override
  public String getMonsterName() {
    return "Vampire";
  }

  @Override
  boolean fightWithMonster(int monsterHealth) {
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
      player.attackToPlayer(Vampire.DAMAGE);
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
  public String getName() {
    return "FOREST";
  }

  @Override
  void earnGift(int leftMonster) {
    if (leftMonster == 0 && player.getHealthy() > 0) {
      System.out.println(
          "Wow you killed all of the vampires in the river. So you earned 'WOODEN'...");
      player.addWooden();
    }
  }
}
