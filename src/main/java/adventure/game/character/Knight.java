package adventure.game.character;

public class Knight implements GameCharacter {

  private static final int HEALTHY = 24;
  private static final int DAMAGE = 8;
  private static final int MONEY = 5;

  @Override
  public int getHealthy() {
    return HEALTHY;
  }

  @Override
  public int getMoney() {
    return MONEY;
  }

  @Override
  public int getDamage() {
    return DAMAGE;
  }
}
