package adventure.game.character;

public class Samurai implements GameCharacter {

  private static final int HEALTHY = 21;
  private static final int DAMAGE = 5;
  private static final int MONEY = 15;

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

  @Override
  public String getName() {
    return "Samurai";
  }
}
