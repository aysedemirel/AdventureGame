package adventure.game.monster;

/**
 * @author aysedemireldeniz
 */
public class Zombie implements Monster {

  public static final int DAMAGE = 3;
  public static final int MONEY = 4;
  private static final int HEALTHY = 10;
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
