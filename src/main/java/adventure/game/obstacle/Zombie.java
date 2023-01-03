package adventure.game.obstacle;

public class Zombie implements Obstacle {

  public static final int DAMAGE = 3;
  public static final int MONEY = 4;
  private static final int HEALTHY = 10;
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
