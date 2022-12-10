package adventure.game.weapon;

public class Sword implements Weapon {

  private static final int DAMAGE = 3;
  private static final int MONEY = 35;

  @Override
  public int giveDamage() {
    return DAMAGE;
  }

  @Override
  public int howMuch() {
    return MONEY;
  }
}
