package adventure.game.location.battle;

import adventure.game.monster.Snake;
import adventure.game.monster.Zombie;
import adventure.game.player.Player;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author aysedemireldeniz
 */
public class Mine extends BattleLocation {

  public Mine(Player player) {
    this.player = player;
    onLocation();
  }

  @Override
  public String getName() {
    return "MINE";
  }

  @Override
  public String getMonsterName() {
    return "Snake";
  }

  @Override
  void createMonsters() {
    randomMonster = new Snake[ThreadLocalRandom.current().nextInt(1, 5)];
    for (int i = 0; i < randomMonster.length; i++) {
      randomMonster[i] = new Snake();
    }
  }

  @Override
  void fightWithMonster(int monsterHealth) {
    if (monsterHealth <= 0) {
      killMonster();
    } else {
      int snakeDamage = Snake.getDamage();
      player.attackToPlayer(snakeDamage);
      System.out.println("One attack from the snake : " + snakeDamage);
    }
    System.out.println("Your left health : " + player.getHealthy());
  }

  @Override
  void earnGift(int leftMonster) {
    if (leftMonster == 0 && player.getHealthy() > 0) {
      System.out.println(
          "Wow you killed all of the snakes in the mine.");
      player.setMineFinish(true);
    }
  }

  @Override
  void killMonster() {
    // FIXME: Random gift (money, weapon, armor or nothing)
    player.addMoney(Zombie.MONEY);
    String st = String.format("""
        +------------------------------+
        | Wooow you killed one snake.  |
        +------------------------------+
        | You earned %d                |
        +------------------------------+""", Zombie.MONEY);
    System.out.println(st);
  }
}
