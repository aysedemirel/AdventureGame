package adventure.game.weapon;

public class Sword implements Weapon {

  public static final int DAMAGE = 3;
  public static final int MONEY = 35;

  @Override
  public int giveDamage() {
    return DAMAGE;
  }

  @Override
  public int howMuch() {
    return MONEY;
  }
}
