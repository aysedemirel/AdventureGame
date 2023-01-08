package adventure.game.location.battle;

import adventure.game.location.Location;
import adventure.game.monster.Monster;
import adventure.game.player.Player;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author aysedemireldeniz
 */
public abstract class BattleLocation implements Location {

  protected Player player;

  protected Monster[] randomMonster;

  protected boolean isMenuActive = false;

  abstract String getMonsterName();

  abstract void createMonsters();

  abstract void fightWithMonster(int monsterHealth);

  abstract void earnGift(int leftMonster);

  abstract void killMonster();

  @Override
  public void showMenu() {
    showMenu(getName());
    isMenuActive = true;
  }

  public boolean isContinue(int leftMonster) {
    return player.getHealthy() > 0 && leftMonster > 0;
  }

  public boolean isMenuActive() {
    return isMenuActive;
  }

  public void setMenuActive(boolean isMenuActive) {
    this.isMenuActive = isMenuActive;
  }

  int controlMonsters(int leftMonster, int damage) {
    boolean isPlayerAttackFirst = ThreadLocalRandom.current().nextBoolean();
    int monsterIndex = leftMonster - 1;
    if (isPlayerAttackFirst) {
      playerAttack(monsterIndex, damage);
    } else {
      monsterAttack(monsterIndex, damage);
    }
    boolean isMonsterDead = !randomMonster[monsterIndex].isAlive();
    if (isMonsterDead) {
      leftMonster--;
      System.out.println("How many " + getMonsterName() + " are alive: " + leftMonster);
    }
    return leftMonster;
  }

  private void playerAttack(int monsterIndex, int damage) {
    System.out.println("Player attack first");
    randomMonster[monsterIndex].giveDamage(damage);
    int monsterHealth = randomMonster[monsterIndex].getHealth();
    fightWithMonster(monsterHealth);
  }

  private void monsterAttack(int monsterIndex, int damage) {
    System.out.println("Monster attack first");
    int monsterHealth = randomMonster[monsterIndex].getHealth();
    fightWithMonster(monsterHealth);
    if (player.getHealthy() > 0) {
      randomMonster[monsterIndex].giveDamage(damage);
      if (!randomMonster[monsterIndex].isAlive()) {
        killMonster();
      }
    }
  }

  void showMenu(String location) {
    String st = String.format("""
        +----------------------+
        |    You are in %s     |
        +----------------------+
        | Look around (1)      |
        | Return main menu (2) |
        +----------------------+""", location);
    System.out.println(st);
  }

  @Override
  public boolean onLocation() {
    showMenu();
    char ch = scanner.next().charAt(0);
    if (ch == '1') {
      createMonsters();
      fight();
    } else if (ch == '2') {
      setMenuActive(false);
    } else {
      System.out.println("Please enter correct input...");
      onLocation();
    }
    return false;
  }

  void fight() {
    showFightMenu(getMonsterName());
    char ch = scanner.next().charAt(0);
    switch (ch) {
      case 'f' -> {
        int leftMonster = randomMonster.length;
        while (ch == 'f' && leftMonster > 0) {
          int damage = giveDamage();
          leftMonster = controlMonsters(leftMonster, damage);
          earnGift(leftMonster);
          ch = continueQuestion(leftMonster);
        }
        setMenuActive(false);
      }
      case 'c' -> setMenuActive(false);
      default -> {
        System.out.println("Please enter correct input...");
        fight();
      }
    }
  }

  int giveDamage() {
    int damage = player.getDamage();
    System.out.println("Your damage: " + damage);
    return damage;
  }

  char continueQuestion(int leftMonster) {
    if (isContinue(leftMonster)) {
      System.out.println(
          "Do you want to change your location (c) or continue attacking(f) ?");
      return scanner.next().charAt(0);
    }
    return '-';
  }

  void showFightMenu(String monsterName) {
    String st = String.format("""      
            +----------------------------------------------------------------------------+
            |                 Be careful!!!! Giant %s... Ohh how many: %d              |
            +----------------------------------------------------------------------------+
            | Do you want to fight or run away?                                          |
            | Fight (f)                                                                  |
            | Change the location (c)                                                    |
            +----------------------------------------------------------------------------+""",
        monsterName,
        randomMonster.length);
    System.out.println(st);
  }
}
