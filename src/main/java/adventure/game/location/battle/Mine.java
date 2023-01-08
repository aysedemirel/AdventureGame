package adventure.game.location.battle;

import adventure.game.monster.Snake;
import adventure.game.player.Player;
import adventure.game.tool.Armor;
import adventure.game.tool.Weapon;
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
    randomMonster = new Snake[ThreadLocalRandom.current().nextInt(1, 6)];
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
    String st = String.format("""
        +------------------------------+
        | Wooow you killed one snake.  |
        +------------------------------+
          You earned %s
        +------------------------------+""", getGift());
    System.out.println(st);
  }

  private Object getGift() {
    Object randomGift = GiftGenerator.getInstance().getRandomGift();
    if (randomGift.equals(Weapon.HANDGUN)) {
      player.addHandgun(false);
    } else if (randomGift.equals(Weapon.RIFLE)) {
      player.addRifle(false);
    } else if (randomGift.equals(Weapon.SWORD)) {
      player.addSword(false);
    } else if (randomGift.equals(Armor.HEAVY)) {
      player.addHeavyArmor(false);
    } else if (randomGift.equals(Armor.MID)) {
      player.addMidArmor(false);
    } else if (randomGift.equals(Armor.LIGHT)) {
      player.addLightArmor(false);
    } else if (randomGift.equals("money-> 1")) {
      player.addMoney(1);
    } else if (randomGift.equals("money-> 5")) {
      player.addMoney(5);
    } else if (randomGift.equals("money-> 10")) {
      player.addMoney(10);
    }
    return randomGift;
  }
}
