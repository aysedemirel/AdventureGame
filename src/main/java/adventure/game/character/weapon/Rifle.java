package adventure.game.character.weapon;

public class Rifle implements Weapon {

  private static final int DAMAGE = 7;
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
