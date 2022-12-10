package adventure.game.armor;

public class LightArmor implements Armor {

  private static final int DAMAGE = 1;
  private static final int MONEY = 15;

  @Override
  public int giveDamage() {
    return DAMAGE;
  }

  @Override
  public int howMuch() {
    return MONEY;
  }
}
