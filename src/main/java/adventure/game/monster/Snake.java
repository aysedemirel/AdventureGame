package adventure.game.monster;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author aysedemireldeniz
 */
public class Snake implements Monster {

  public static final int HEALTHY = 12;
  private int health = HEALTHY;

  public static int getDamage() {
    return ThreadLocalRandom.current().nextInt(3, 6);
  }

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
