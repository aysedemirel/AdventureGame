package adventure.game.obstacle;

public class Bear implements Obstacle {

  private static final int DAMAGE = 7;
  private static final int HEALTHY = 20;
  private static final int MONEY = 12;

  @Override
  public int giveDamage() {
    return DAMAGE;
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
