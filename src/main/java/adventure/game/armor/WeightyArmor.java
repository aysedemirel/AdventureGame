package adventure.game.armor;

public class WeightyArmor implements Armor {

  private static final int DAMAGE = 5;
  private static final int MONEY = 45;

  @Override
  public int giveDamage() {
    return DAMAGE;
  }

  @Override
  public int howMuch() {
    return MONEY;
  }
}
