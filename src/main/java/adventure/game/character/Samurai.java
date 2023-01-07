package adventure.game.character;

/**
 * @author aysedemireldeniz
 */
public class Samurai implements GameCharacter {

  private static final int HEALTHY = 21;
  private static final int DAMAGE = 5;
  private static final int MONEY = 15;

  public static String getCharMenu() {
    Samurai samurai = new Samurai();
    return String.format("""             
        | %s (s) | Damage: %d | Health: %d | Money: %d |
        +--------------+------------+------------+-----------+
        """, samurai.getName(), samurai.getDamage(), samurai.getHealthy(), samurai.getMoney());
  }

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
