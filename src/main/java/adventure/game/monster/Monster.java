package adventure.game.monster;

/**
 * @author aysedemireldeniz
 */
public interface Monster {

  void giveDamage(int damage);

  int getHealth();

  boolean isAlive();
}
