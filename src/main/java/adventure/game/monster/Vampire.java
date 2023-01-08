package adventure.game.monster;

/**
 * @author aysedemireldeniz
 */
public class Vampire implements Monster {

  public static final int DAMAGE = 4;
  public static final int MONEY = 7;
  private static final int HEALTHY = 14;
  private int health = HEALTHY;

  @Override
  public void giveDamage(int damage) {
    health -= damage;
  }

  @Override
  public int getHealth() {
    return health;
  }

  @Override
  public boolean isAlive() {
    return health > 0;
  }
}
