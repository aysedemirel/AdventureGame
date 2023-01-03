package adventure.game.obstacle;

public class Zombie implements Obstacle {

  private static final int DAMAGE = 3;
  private static final int HEALTHY = 10;
  private static final int MONEY = 4;
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
