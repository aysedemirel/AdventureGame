package adventure.game.obstacle;

public class Vampire implements Obstacle {

  public static final int DAMAGE = 4;
  public static final int MONEY = 7;
  private static final int HEALTHY = 14;
  private int health = HEALTHY;

  @Override
  public int giveDamage(int damage) {
    health -= damage;
    return health;
  }

  @Override
  public int getHealthy() {
    return HEALTHY;
  }

  @Override
  public int giveMoney() {
    return MONEY;
  }
}
