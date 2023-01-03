package adventure.game.weapon;

public class Rifle implements Weapon {

  public static final int DAMAGE = 7;
  public static final int MONEY = 45;

  @Override
  public int giveDamage() {
    return DAMAGE;
  }

  @Override
  public int howMuch() {
    return MONEY;
  }
}
