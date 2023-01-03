package adventure.game.armor;

public class MidArmor implements Armor {

  public static final int DAMAGE = 3;
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
