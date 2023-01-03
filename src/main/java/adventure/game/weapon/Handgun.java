package adventure.game.weapon;

public class Handgun implements Weapon {

  public static final int DAMAGE = 2;
  public static final int MONEY = 25;

  @Override
  public int giveDamage() {
    return DAMAGE;
  }

  @Override
  public int howMuch() {
    return MONEY;
  }
}
