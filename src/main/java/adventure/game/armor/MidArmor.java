package adventure.game.armor;

public class MidArmor implements Armor {

  private static final int DAMAGE = 3;
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
