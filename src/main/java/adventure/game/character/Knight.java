package adventure.game.character;

public class Knight implements GameCharacter {

  private static final int HEALTHY = 24;
  private static final int DAMAGE = 8;
  private static final int MONEY = 5;

  public static String getCharMenu() {
    Knight knight = new Knight();
    return String.format("""             
        | %s (k) | Damage: %d | Health: %d | Money: %d |
        +--------------+------------+------------+-----------+
        """, knight.getName(), knight.getDamage(), knight.getHealthy(), knight.getMoney());
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
    return "Knight";
  }
}
