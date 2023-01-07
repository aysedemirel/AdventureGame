package adventure.game.monster;

public class Bear implements Monster {

  public static final int HEALTHY = 20;
  public static final int DAMAGE = 7;
  public static final int MONEY = 12;

  private int health = HEALTHY;

  @Override
  public int giveDamage(int damage) {
    health -= damage;
    return health;
  }
}
