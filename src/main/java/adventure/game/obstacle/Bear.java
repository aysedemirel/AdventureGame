package adventure.game.obstacle;

public class Bear implements Obstacle {

  public static final int DAMAGE = 7;
  public static final int HEALTHY = 20;
  public static final int MONEY = 12;

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
