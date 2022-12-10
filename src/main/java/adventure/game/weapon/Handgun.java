package adventure.game.weapon;

public class Handgun implements Weapon {

  private static final int DAMAGE = 2;
  private static final int MONEY = 25;

  @Override
  public int giveDamage() {
    return DAMAGE;
  }

  @Override
  public int howMuch() {
    return MONEY;
  }
}
