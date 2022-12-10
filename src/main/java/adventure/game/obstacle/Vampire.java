package adventure.game.obstacle;

public class Vampire implements Obstacle {

  private static final int DAMAGE = 4;
  private static final int HEALTHY = 14;
  private static final int MONEY = 7;

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
