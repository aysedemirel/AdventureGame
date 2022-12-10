package adventure.game.character;

public class Archer implements GameCharacter {

  private static final int HEALTHY = 18;
  private static final int DAMAGE = 7;
  private static final int MONEY = 20;

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
