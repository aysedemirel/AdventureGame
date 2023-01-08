package adventure.game.monster;

/**
 * @author aysedemireldeniz
 */
public class Bear implements Monster {

  public static final int HEALTHY = 20;
  public static final int DAMAGE = 7;
  public static final int MONEY = 12;
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
