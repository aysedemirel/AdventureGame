package adventure.game.location.battle;

import adventure.game.monster.Vampire;
import adventure.game.monster.Zombie;
import adventure.game.player.Player;

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
    // FIXME: Create with snake
//    randomMonster = new Vampire[ThreadLocalRandom.current().nextInt(1, 3)];
//    for (int i = 0; i < randomMonster.length; i++) {
//      randomMonster[i] = new Vampire();
//    }
  }

  @Override
  void fightWithMonster(int monsterHealth) {
    if (monsterHealth <= 0) {
      killMonster();
    } else {
      // FIXME: Snake.DAMAGE
      player.attackToPlayer(Vampire.DAMAGE);
      System.out.println("One attack from the snake : " + Vampire.DAMAGE);
    }
    System.out.println("Your left health : " + player.getHealthy());
  }

  @Override
  void earnGift(int leftMonster) {
    if (leftMonster == 0 && player.getHealthy() > 0) {
      System.out.println(
          "Wow you killed all of the snakes in the mine.");
      // TODO: player should finish mine
      // player.addWooden();
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
