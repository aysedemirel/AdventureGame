package adventure.game.monster;

public class Vampire implements Monster {

  public static final int DAMAGE = 4;
  public static final int MONEY = 7;
  private static final int HEALTHY = 14;
  private int health = HEALTHY;

  @Override
  public int giveDamage(int damage) {
    health -= damage;
    return health;
  }
}
